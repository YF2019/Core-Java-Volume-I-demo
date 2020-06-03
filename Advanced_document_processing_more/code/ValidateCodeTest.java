package code;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;



public class ValidateCodeTest {

	//û��1 I L 0 o
	static char[] codeSequence = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K', 'M', 'N', 'P', 'Q', 'R', 'S', 'T',
			'U', 'V', 'W', 'X', 'Y', 'Z', '2', '3', '4', '5', '6', '7', '8', '9' };
	static int charNum = codeSequence.length;
	
	public static void main(String[] a) throws IOException
	{
		generateCode("c:/temp/code.jpg");
	}	
	

	public static void generateCode(String filePath) throws IOException {
		// ���ȶ�����֤��ͼƬ��  
		int width = 80; // ��֤��ͼƬ�Ŀ��
		int height = 32; // ��֤��ͼƬ�ĸ߶�
        BufferedImage buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB); 
        
        
        //����ͼƬ�ϵ�ͼ�κ͸�����
        Graphics2D gd = buffImg.createGraphics();   
        gd.setColor(Color.LIGHT_GRAY);   // ��ͼ�����Ϊǳ��ɫ   
        gd.fillRect(0, 0, width, height);   
        gd.setColor(Color.BLACK);        // ���߿�   
        gd.drawRect(0, 0, width - 1, height - 1);   
        // �������16����ɫ�����ߣ�ʹͼ���е���֤�벻��ʶ��  
        gd.setColor(Color.gray); 
        // ����һ���������������   �����������������
        Random random = new Random();   
        for (int i = 0; i < 16; i++) {   
            int x = random.nextInt(width);   
            int y = random.nextInt(height);   
            int xl = random.nextInt(12);   
            int yl = random.nextInt(12);   
            gd.drawLine(x, y, x + xl, y + yl);   
        }   
        
        
        //�����ֵ�λ������
        int codeCount = 4; // �ַ�����
    	int fontHeight; // ����߶�
    	int codeX; // ��һ���ַ���x���꣬��Ϊ������ַ��������ε������������ǵ�x��ֵ��codeX�ı���
    	int codeY; // ��֤�ַ���y���꣬��Ϊ��������ֵһ��
    	// width-4 ��ȥ���Ҷ����λ�ã�ʹ��֤����Ӽ�����ʾ������Խ��Խ���С�
    	// codeCount+1 //�ȱȷ�����ʾ�Ŀ�ȣ������������ߵĿո�
    	codeX = (width - 4) / (codeCount + 1); //��һ����ĸ����ʼλ��    	
    	fontHeight = height - 10;  // height - 10 �߶��м�������ʾ��֤��
    	codeY = height - 7;
    			
    			
        // �������壬����Ĵ�СӦ�ø���ͼƬ�ĸ߶�������   
        Font font = new Font("Fixedsys", Font.PLAIN, fontHeight);           
        gd.setFont(font);   
        
        // �������codeCount���ֵ���֤�롣   
        for (int i = 0; i < codeCount; i++) {   
            // ÿ�������һ����ĸ�������������ɫ  
            String strRand = String.valueOf(codeSequence[random.nextInt(charNum)]);   
            int red = random.nextInt(255);   
            int green = random.nextInt(255);   
            int blue = random.nextInt(255);   
            gd.setColor(new Color(red,green,blue));   
            //���ַŵ�ͼƬ��!!!
            gd.drawString(strRand, (i + 1) * codeX, codeY);              
        }   
        
        ImageIO.write(buffImg, "jpg", new File(filePath));             
	}
}
