package org.imageprocessing.improject.programproperties;

import java.awt.image.BufferedImage;

import org.imageprocessing.improject.components.panels.ImagePanel;

public class ImageManager {

	private ImagePanel imgpanel;


	public ImageManager() {

	}

	public void setImgpanel(ImagePanel imgpanel) {
		this.imgpanel = imgpanel;
	}

	public ImagePanel getImgpanel() {
		return imgpanel;
	}

	public void setImage(BufferedImage image) {
		if(imgpanel != null) {
			imgpanel.setImage(image);
			imgpanel.repaint();
		}
	}

	public BufferedImage getImage() {
		if(imgpanel != null) {
			return imgpanel.getImage();
		}
		else {
			return null;
		}
	}

}
