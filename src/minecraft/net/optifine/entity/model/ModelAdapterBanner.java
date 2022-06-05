package net.optifine.entity.model;

import net.minecraft.client.model.ModelBanner;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityBannerRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.src.Reflector;
import net.minecraft.src.ReflectorField;
import net.minecraft.tileentity.TileEntityBanner;

public class ModelAdapterBanner extends ModelAdapter
{
    public ModelAdapterBanner()
    {
        super(TileEntityBanner.class, "banner", 0.0F);
    }

    public ModelBase makeModel()
    {
        return new ModelBanner();
    }

    public ModelRenderer getModelRenderer(ModelBase model, String modelPart)
    {
        if (!(model instanceof ModelBanner))
        {
            return null;
        }
        else
        {
            ModelBanner modelbanner = (ModelBanner)model;
            return modelPart.equals("slate") ? modelbanner.bannerSlate : (modelPart.equals("stand") ? modelbanner.bannerStand : (modelPart.equals("top") ? modelbanner.bannerTop : null));
        }
    }

    public IEntityRenderer makeEntityRender(ModelBase modelBase, float shadowSize)
    {
        TileEntityRendererDispatcher tileentityrendererdispatcher = TileEntityRendererDispatcher.instance;
        TileEntitySpecialRenderer tileentityspecialrenderer = tileentityrendererdispatcher.getSpecialRendererByClass(TileEntityBanner.class);

        if (!(tileentityspecialrenderer instanceof TileEntityBannerRenderer))
        {
            return null;
        }
        else
        {
            if (tileentityspecialrenderer.getEntityClass() == null)
            {
                tileentityspecialrenderer = new TileEntityBannerRenderer();
                tileentityspecialrenderer.setRendererDispatcher(tileentityrendererdispatcher);
            }

            ReflectorField reflectorfield = Reflector.getReflectorField(TileEntityBannerRenderer.class, ModelBanner.class);

            if (reflectorfield == null)
            {
                return null;
            }
            else
            {
                reflectorfield.setValue(tileentityspecialrenderer, modelBase);
                return tileentityspecialrenderer;
            }
        }
    }
}