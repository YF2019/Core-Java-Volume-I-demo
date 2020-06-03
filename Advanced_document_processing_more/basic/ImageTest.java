package basic;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

public class ImageTest {

	public static void main(String[] args) throws Exception {
		readAndWrite();
		readComparison();			
		cropImage("c:/temp/ecnu.jpg", "c:/temp/shida.jpg", 750, 250, 700, 300, "jpg", "jpg");
		combineImagesHorizontally("c:/temp/ecnu.jpg","c:/temp/ecnu.jpg","jpg", "c:/temp/ecnu2.jpg");
		combineImagesVertically("c:/temp/ecnu.jpg","c:/temp/ecnu.jpg","jpg", "c:/temp/ecnu3.jpg");
	}

	public static void readAndWrite() throws Exception {
		BufferedImage image = ImageIO.read(new File("c:/temp/ecnu.jpg"));
		System.out.println("Height: " + image.getHeight()); // �߶�����
		System.out.println("Width: " + image.getWidth()); // �������
		ImageIO.write(image, "png", new File("c:/temp/ecnu.png"));
	}

	public static void readComparison() throws Exception {
		System.out.println("===========�����ٶȲ���==============");

		// ImageIO��Ҫ����ͼƬ�����ͣ����غ��ʵ�ImageReader����ȡͼƬ����ʱ����
		long startTime = System.nanoTime();
		BufferedImage image = ImageIO.read(new File("c:/temp/ecnu.jpg"));
		System.out.println("Height: " + image.getHeight()); // �߶�����
		System.out.println("Width: " + image.getWidth()); // �������
		long endTime = System.nanoTime();
		System.out.println((endTime - startTime) / 1000000.0 + "����");

		// ָ����jpg Reader�����أ��ٶȻ�ӿ�
		startTime = System.nanoTime();
		Iterator<ImageReader> readers = ImageIO.getImageReadersByFormatName("jpg");
		ImageReader reader = (ImageReader) readers.next();
		System.out.println(reader.getClass().getName());
		ImageInputStream iis = ImageIO.createImageInputStream(new File("c:/temp/ecnu.jpg"));
		reader.setInput(iis, true);
		System.out.println("Height:" + reader.getHeight(0));
		System.out.println("Width:" + reader.getWidth(0));
		endTime = System.nanoTime();
		System.out.println((endTime - startTime) / 1000000.0 + "����");
	}

	/**
	 * cropImage ��ԭʼͼƬ�ļ��и�һ�����Σ��������Ŀ��ͼƬ�ļ�
	 * @param fromPath ԭʼͼƬ
	 * @param toPath  Ŀ��ͼƬ
	 * @param x       �������x
	 * @param y       �������y
	 * @param width   ���ο��
	 * @param height  ���θ߶�
	 * @param readImageFormat  ԭʼ�ļ���ʽ
	 * @param writeImageFormat Ŀ���ļ���ʽ
	 * @throws Exception
	 */
	public static void cropImage(String fromPath, String toPath, int x, int y, int width, int height, String readImageFormat,
			String writeImageFormat) throws Exception {
		FileInputStream fis = null;
		ImageInputStream iis = null;
		try {
			// ��ȡԭʼͼƬ�ļ�
			fis = new FileInputStream(fromPath);
			Iterator<ImageReader> it = ImageIO.getImageReadersByFormatName(readImageFormat);
			ImageReader reader = it.next();			
			iis = ImageIO.createImageInputStream(fis);
			reader.setInput(iis, true);
			
			// ����һ������ �������и������
			ImageReadParam param = reader.getDefaultReadParam();			
			Rectangle rect = new Rectangle(x, y, width, height);			
			param.setSourceRegion(rect);
			
			//��Դ�ļ���ȡһ�����δ�С��ͼ��
			BufferedImage bi = reader.read(0, param);
			
			//д�뵽Ŀ���ļ�
			ImageIO.write(bi, writeImageFormat, new File(toPath));
		} finally {
			fis.close();
			iis.close();
		}
	}

	/**
     * ����ƴ������ͼƬ����д�뵽Ŀ���ļ�
     * ƴ�ӵı��ʣ���������һ������¿ռ䣬Ȼ��ԭʼ��ͼƬ���ص㿽�����¿ռ䣬��󱣴�
     * @param firstPath ��һ��ͼƬ��·��
     * @param secondPath    �ڶ���ͼƬ��·��
     * @param imageFormat   ƴ������ͼƬ�ĸ�ʽ
     * @param toPath    Ŀ��ͼƬ��·��
     */
    public static void combineImagesHorizontally(String firstPath, String secondPath,String imageFormat, String toPath){  
        try {  
            //��ȡ��һ��ͼƬ    
            File  first  =  new  File(firstPath);    
            BufferedImage  imageOne = ImageIO.read(first);    
            int  width1  =  imageOne.getWidth();//ͼƬ���    
            int  height1  =  imageOne.getHeight();//ͼƬ�߶�    
            //�ӵ�һ��ͼƬ�ж�ȡRGB    
            int[]  firstRGB  =  new  int[width1*height1];    
            firstRGB  =  imageOne.getRGB(0,0,width1,height1,firstRGB,0,width1);    

            //�Եڶ���ͼƬ��ͬ���Ĵ���    
            File  second  =  new  File(secondPath);    
            BufferedImage  imageTwo  =  ImageIO.read(second); 
            int width2 = imageTwo.getWidth();
            int height2 = imageTwo.getHeight();
            int[]   secondRGB  =  new  int[width2*height2];    
            secondRGB  =  imageTwo.getRGB(0,0,width2,height2,secondRGB,0,width2);   
            

            //������ͼƬ
            int height3 = (height1>height2)?height1:height2; //��ѡ�߶ȴ�ģ���ΪĿ���ļ��ĸ߶�
            int width3  = width1 + width2;                   //��ȣ�����ͼƬ���
            BufferedImage  imageNew  =  new  BufferedImage(width3,height3,BufferedImage.TYPE_INT_RGB);    
            
            //������벿�ֵ�RGB ��(0,0) ��ʼ 
            imageNew.setRGB(0,0,width1,height1,firstRGB,0,width1); 
            //�����Ұ벿�ֵ�RGB ��(width1, 0) ��ʼ 
            imageNew.setRGB(width1,0,width2,height2,secondRGB,0,width2);
               
            //����ͼƬ
            ImageIO.write(imageNew,  imageFormat,  new  File(toPath));
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }

    /**
     * ����ƴ��ͼƬ�����ţ�
     * ƴ�ӵı��ʣ���������һ������¿ռ䣬Ȼ��ԭʼ��ͼƬ���ص㿽�����¿ռ䣬��󱣴�
     * @param firstPath ��ȡ�ĵ�һ��ͼƬ
     * @param secondPath    ��ȡ�ĵڶ���ͼƬ
     * @param imageFormat ͼƬд���ʽ
     * @param toPath    ͼƬд��·��
     */
    public static void combineImagesVertically(String firstPath, String secondPath,String imageFormat, String toPath){  
        try {  
            //��ȡ��һ��ͼƬ    
            File  first  =  new  File(firstPath);    
            BufferedImage  imageOne = ImageIO.read(first);    
            int  width1  =  imageOne.getWidth();//ͼƬ���    
            int  height1  =  imageOne.getHeight();//ͼƬ�߶�    
            //��ͼƬ�ж�ȡRGB    
            int[]  firstRGB  =  new  int[width1*height1];    
            firstRGB  =  imageOne.getRGB(0,0,width1,height1,firstRGB,0,width1);    

            //�Եڶ���ͼƬ����ͬ�Ĵ���    
            File  second  =  new  File(secondPath);    
            BufferedImage  imageTwo  =  ImageIO.read(second); 
            int width2 = imageTwo.getWidth();
            int height2 = imageTwo.getHeight();
            int[]   secondRGB  =  new  int[width2*height2];    
            secondRGB  =  imageTwo.getRGB(0,0,width2,height2,secondRGB,0,width2); 

            //������ͼƬ
            int width3 = (width1>width2)?width1:width2; //��ѡ��ȴ�ģ���ΪĿ���ļ��Ŀ��
            int height3 = height1+height2;              //�߶ȣ�����ͼƬ���
            BufferedImage  imageNew  =  new  BufferedImage(width3,height3,BufferedImage.TYPE_INT_RGB);    
            //�����ϰ벿�ֵ�RGB ��(0,0) ��ʼ 
            imageNew.setRGB(0,0,width1,height1,firstRGB,0,width1);
            //�����°벿�ֵ�RGB ��(0, height1) ��ʼ 
            imageNew.setRGB(0,height1,width2,height2,secondRGB,0,width2);  

            //����ͼƬ
            ImageIO.write(imageNew, imageFormat, new File(toPath));
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }
}
