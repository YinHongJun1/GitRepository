package com.mashibing.util;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.cglib.beans.BeanMap;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 解析Excel表格工具类
 */
public class ExcelUtil {
    /**
     * 解析表格方法(通用)
     * @param stream 文件输入流
     * @param clazz 实体类类型
     * @param <T> 任何数据类型
     * @return 解析表格的结果
     */
    public static <T> List<T> readExcel(FileInputStream stream,Class<T> clazz) throws InstantiationException, IllegalAccessException {
        List<T> list = new ArrayList<>();
        // 1、从输入流中获取工作簿
        XSSFWorkbook workbook = new XSSFWorkbook();
        // 2、在工作簿中获取目标工作表
        Sheet sheet = workbook.getSheetAt(0);
        // 3、在工作表中获取行数
        int rows = sheet.getPhysicalNumberOfRows();
        // 4、获取第一行的数据
        Row row = sheet.getRow(0);
        // 5、遍历第一行数据，遍历出的就是实体类中需要新增的所有属性，并且将其作为key放入一个集合中
        List<String> keys = new ArrayList<>();
        // 6、遍历第一行的数据，将所有数据放入到key集合中
        for (Cell cell: row) {
            cell.setCellType(Cell.CELL_TYPE_STRING);
            keys.add(cell.getStringCellValue());
        }
        // 7、遍历所有的正式数据，从但是要跳过第二行标题数据
        for (int i = 2; i < rows; i++) {
            // 8、获取所有行
           row = sheet.getRow(i);
           if (row != null){
               // 9、遍历所有单元格中的数据，并且把key和value放入map集合中进行映射
               // 计数器
               int j = 0;
               Map<String, String> excelMap = new HashMap<>();
               for (Cell cell: row) {
                   if(cell != null){
                       // 10、把所有单元格中的数据格式设置为string
                       cell.setCellType(Cell.CELL_TYPE_STRING);
                       // 11、获取所有单元格数据
                       String value = cell.getStringCellValue();
                       if (value != null && !value.equals("")){
                           // 12、将每个单元格的数据存储到集合中
                           excelMap.put(keys.get(j), value);
                           j++;
                       }
                   }
               }
               // 12、创建对应的实体类类型
               T t = clazz.newInstance();
               /**
                * Spring提供的BeanMap.它可以通过反射的形式把Map中的数据映射到实体类中
                */
               BeanMap beanMap = BeanMap.create(t);
               beanMap.putAll(excelMap);
               list.add(t);

           }
        }

        return list;
    }
}
