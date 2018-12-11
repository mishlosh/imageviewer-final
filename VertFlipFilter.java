/**
 * An image filter to make the image flipped vertically.
 * 
 * @author Michal Legocki.
 * @version 1.0
 */
public class VertFlipFilter extends Filter
{
    /**
     * Constructor for objects of class DarkerFilter.
     * @param name The name of the filter.
     */
    public VertFlipFilter(String name)
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
        OFImage flipped = new OFImage(width,height);
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                flipped.setPixel(x, height-y, image.getPixel(x, y));
            }
        }
        image = flipped;
    }
}
