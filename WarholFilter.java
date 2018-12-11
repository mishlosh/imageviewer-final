import java.awt.Color;
/**
 * An image filter to make the image a Warhol painting:
 * Top left inverted, Top right red
 * Bot left blue    , Bot right green.
 * 
 * @author Michal Legocki
 * @version 1.0
 */
public class WarholFilter extends Filter
{
    /**
     * Constructor for objects of class DarkerFilter.
     * @param name The name of the filter.
     */
    public WarholFilter(String name)
    {
        super(name);
    }

    /**
     * Apply this filter to an image.
     * 
     * @param  image  The image to be changed by this filter.
     */
    public void apply(OFImage image)
    {
        int height = image.getHeight();
        int width = image.getWidth();
        OFImage invert = new OFImage(width/2,height/2);
        OFImage red = new OFImage(width/2,height/2);
        OFImage blue = new OFImage(width/2,height/2);
        OFImage green = new OFImage(width/2,height/2);
        OFImage warhol = new OFImage(width,height);
        for(int y = 0; y < height/2; y++) {
            for(int x = 0; x < width/2; x++) {
                Color pix = image.getPixel(x*2, y*2);
                invert.setPixel(x, y, new Color(255 - pix.getRed(),
                                               255 - pix.getGreen(),
                                               255 - pix.getBlue()));
                red.setPixel(x, y, new Color(pix.getRed(),
                                               255,
                                               255));
                blue.setPixel(x, y, new Color(255,
                                               255,
                                               pix.getBlue()));
                green.setPixel(x, y, new Color(255,
                                               pix.getGreen(),
                                               255));
                warhol.setPixel(x,          y,            invert.getPixel(x,y));
                warhol.setPixel(x+(width/2),y,            red.getPixel(x,y));
                warhol.setPixel(x,          y+(height/2), blue.getPixel(x,y));
                warhol.setPixel(x+(width/2),y+(height/2), green.getPixel(x,y));
            }
        }
        image=warhol;
    }
}
