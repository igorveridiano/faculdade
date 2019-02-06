package conversaoDeImagens;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Conversor implements Runnable {
	
	private static BufferedImage imagem;
	private int larguraInicio;
	private int alturaInicio;
	private int larguraFim;
	private int alturaFim;
	
	
	public Conversor() {
	}
	
	public Conversor(File diretorio) {
		try {
			Conversor.setImagem(ImageIO.read(diretorio));
		} catch (IOException e) {
		}
	}
	
	public Conversor(String diretorio) {
		try {
			Conversor.setImagem(ImageIO.read(new File(diretorio)));
		} catch (IOException e) {
		}
	}
	
	public Conversor(int larguraInicio, int alturaInicio, int larguraFim, int alturaFim) {
		this.setLarguraInicio(larguraInicio);
		this.setAlturaInicio(alturaInicio);
		this.setLarguraFim(larguraFim);
		this.setAlturaFim(alturaFim);
	}

	@Override
	public void run() {
		for (int i = getLarguraInicio(); i < getLarguraFim(); i++) {
			for (int j = getAlturaInicio(); j < getAlturaFim(); j++) {
				Color c = new Color(getImagem().getRGB(i, j));
				int tonalidadeCinza = (c.getRed() + c.getGreen() + c.getBlue()) / 3;
				c = new Color(tonalidadeCinza, tonalidadeCinza, tonalidadeCinza);
				getImagem().setRGB(i, j, c.getRGB());
			}
		}
	}
	
	public void Converter(String diretorio2){
		try {
			ImageIO.write(getImagem(), "JPG", new File(diretorio2));
		} catch (IOException e) {
		}
	}

	public static BufferedImage getImagem() {
		return imagem;
	}

	public static void setImagem(BufferedImage imagem) {
		Conversor.imagem = imagem;
	}

	public int getLarguraInicio() {
		return larguraInicio;
	}

	public void setLarguraInicio(int larguraInicio) {
		this.larguraInicio = larguraInicio;
	}

	public int getAlturaInicio() {
		return alturaInicio;
	}

	public void setAlturaInicio(int alturaInicio) {
		this.alturaInicio = alturaInicio;
	}

	public int getLarguraFim() {
		return larguraFim;
	}

	public void setLarguraFim(int larguraFim) {
		this.larguraFim = larguraFim;
	}

	public int getAlturaFim() {
		return alturaFim;
	}

	public void setAlturaFim(int alturaFim) {
		this.alturaFim = alturaFim;
	}	
}
