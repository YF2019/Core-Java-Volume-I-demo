import java.io.File ;  
import java.io.FileInputStream ;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry ;  
import java.util.zip.ZipInputStream ;   
public class SingleFileUnzip{  
    public static void main(String args[]) throws Exception{     
        //待解压文件, 需要从zip文件打开输入流，读取数据到java中
    	File zipFile = new File("c:/temp/single2.zip") ;   // 定义压缩文件名称          
        ZipInputStream input = null ;   // 定义压缩输入流  
        input = new ZipInputStream(new FileInputStream(zipFile)) ;  // 实例化ZIpInputStream  
        ZipEntry entry = input.getNextEntry() ; // 得到一个压缩实体  
        System.out.println("压缩实体名称：" + entry.getName()) ;  //获取压缩包中文件名字 
        
        //新建目标文件，需要从目标文件打开输出流，数据从java流入
        File outFile = new File("c:/temp/" + entry.getName());
        OutputStream out = new FileOutputStream(outFile) ;   // 实例化文件输出流  
        int temp = 0 ;  
        while((temp=input.read())!=-1){  
            out.write(temp) ;  
        }  
        input.close() ;     // 关闭输入流  
        out.close() ;   // 关闭输出流
        System.out.println("unzip done.") ;
    }  
}