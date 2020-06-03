package charts;

import java.awt.Font;
import java.io.File;
import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public class JFreeChartTest {

	public static void main(String[] args) {
		writeBar("c:/temp/bar.jpg"); // ��״ͼ
		writePie("c:/temp/pie.jpg"); // ��ͼ
		writeLine("c:/temp/line.jpg");// ����ͼ
	}
	
	public static StandardChartTheme getChineseTheme()
	{
		StandardChartTheme chineseTheme = new StandardChartTheme("CN");
		chineseTheme.setExtraLargeFont(new Font("����", Font.BOLD, 20));
		chineseTheme.setRegularFont(new Font("����", Font.PLAIN, 15));
		chineseTheme.setLargeFont(new Font("����", Font.PLAIN, 15));
		return chineseTheme;
	}
	
	public static void writeBar(String fileName) {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.addValue(11, "", "��һ����");
		dataset.addValue(41, "", "�ڶ�����");
		dataset.addValue(51, "", "��������");
		dataset.addValue(4, "", "���ļ���");

		// PlotOrientation.HORIZONTAL���� PlotOrientation.VERTICAL ����
		// ��������������ʽ
		ChartFactory.setChartTheme(getChineseTheme());
		JFreeChart chart = ChartFactory.createBarChart3D("��״ͼ", "2018��", "��Ʒ����", dataset, PlotOrientation.VERTICAL,
				false, false, false);

		try {
			ChartUtilities.saveChartAsJPEG(new File(fileName), chart, 600, 300);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void writePie(String fileName) {
		DefaultPieDataset pds = new DefaultPieDataset();
		pds.setValue("C����", 100);
		pds.setValue("C++����", 200);
		pds.setValue("Java����", 300);
		try {
			ChartFactory.setChartTheme(getChineseTheme());
			JFreeChart chart = ChartFactory.createPieChart("��ͼ", pds);
			
			ChartUtilities.saveChartAsJPEG(new File(fileName), chart, 600, 300);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void writeLine(String fileName) {
		DefaultCategoryDataset lines = new DefaultCategoryDataset();
		//��һ����
		lines.addValue(100, "Java���ļ���", "1��");
		lines.addValue(200, "Java���ļ���", "2��");
		lines.addValue(400, "Java���ļ���", "3��");
		lines.addValue(500, "Java���ļ���", "4��");
		
		//�ڶ�����
		lines.addValue(100, "Java���ļ���(����)", "1��");
		lines.addValue(400, "Java���ļ���(����)", "2��");
		lines.addValue(900, "Java���ļ���(����)", "3��");
		try {
			ChartFactory.setChartTheme(getChineseTheme());
			JFreeChart chart = ChartFactory.createLineChart("����ͼ", "ʱ��", "����", lines);
			ChartUtilities.saveChartAsJPEG(new File(fileName), chart, 600, 300);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
