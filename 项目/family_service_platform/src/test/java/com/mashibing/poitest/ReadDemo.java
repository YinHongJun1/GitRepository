package com.mashibing.poitest;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class ReadDemo {
    public static void main(String[] args) {
        try {
            List<Product> products = read("");
            for (Product product: products) {
                System.out.println(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static List<Product> read(String path) throws Exception {
        List<Product> products = new ArrayList<>();
        // 1、创建输入流
        FileInputStream fip = new FileInputStream(path);
        // 2、在输入流中获取工作簿
        XSSFWorkbook workbook = new XSSFWorkbook(fip);
        // 3、在工作簿中获取目标的工作表
        Sheet sheet = workbook.getSheetAt(0);
        // 4、获取工作表的行数
        int rows = sheet.getPhysicalNumberOfRows();
        // 第一行是标题，不需要获取
        for (int i = 1; i < rows; i++) {
            // 5、获取除了第一行的所有行
            Row row = sheet.getRow(i);
            if (row != null) {
                // 6、把所有单元格的数据保存
                List<String> list = new ArrayList<>();
                for (Cell cell : row) {
                    if (cell != null) {
                        // 7、把单元格中的所有的数据格式设置为string
                        cell.setCellType(Cell.CELL_TYPE_STRING);
                        // 8、获取所有单元格的数据
                        String value = cell.getStringCellValue();
                        if (value != null && !value.equals("")) {
                            // 9、将每一个单元格的数据放入集合中
                            list.add(value);
                        }
                    }
                }
                // 10、把获取到的每一条数据封装成一个Product类型
                if (list.size() > 0){
                    Product product = new Product(Integer.parseInt(list.get(0)),list.get(1),Double.parseDouble(list.get(2)),Integer.parseInt(list.get(3)));
                    // 11、再将每一个product实体数据封装到Product的list集合中
                    products.add(product);
                }
            }

        }
        return products;
    }
}
