import cn.hutool.core.io.resource.ClassPathResource;
import cn.hutool.core.util.ClassUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.data.ImageData;
import com.alibaba.excel.metadata.data.WriteCellData;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.excel.util.FileUtils;
import com.alibaba.excel.util.MapUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author 吴凯斌
 * 创建时间 2023/7/6 17:44
 */
public class FillImageTest {
    @Test
    public void imageWrite() throws Exception {
        // 模板文件
        ClassPathResource classPathResource = new ClassPathResource("excelTemplate/开店区域推荐导出模板.xlsx");
        InputStream inputStream = classPathResource.getStream();
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        workbook.write(byteArrayOutputStream);
        byte[] bytes = byteArrayOutputStream.toByteArray();
        ByteArrayInputStream template = new ByteArrayInputStream(bytes);

        // 导出文件路径
        String fileName = ClassUtil.getClassPath() + "imageWrite" + System.currentTimeMillis() + ".xlsx";

        URL url = new URL("https://location-pdf.oss-cn-hangzhou.aliyuncs.com/3925004f-c936-4ed1-a0cf-b9bba20b495f.png");
        // 设置图片数据
        URL[] files = {url, url};
        WriteCellData<Void> imageCells = this.imageCells(files);

        // 构造map
        Map<String, Object> map = MapUtils.newHashMap();
        map.put("images", imageCells);

//        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        EasyExcelFactory.write(fileName)
                .excelType(ExcelTypeEnum.XLSX)
                .withTemplate(template).sheet().doFill(map);

        System.out.println("导出文件位置：" + fileName);
    }

    /**
     * Excel所有图片设置
     * @param urls
     * @return
     * @throws IOException
     */
    private WriteCellData<Void> imageCells(URL[] urls) throws IOException {
        if (urls == null) {
            return null;
        }

        WriteCellData<Void> writeCellData = new WriteCellData<>();
        // 这里可以设置为 EMPTY 则代表不需要其他数据了
        //writeCellData.setType(CellDataTypeEnum.EMPTY);

        // 可以放入多个图片
        List<ImageData> imageDataList = new ArrayList<>();
        writeCellData.setImageDataList(imageDataList);

        for (int i = 0; i < urls.length; i++) {
            // 限制最多3张图片
            if (i >= 3) {
                break;
            }

            ImageData imageData = new ImageData();
            imageDataList.add(imageData);
            // 设置图片
            imageData.setImage(urlToByteArray(urls[i]));
            // 图片类型
            //imageData.setImageType(ImageData.ImageType.PICTURE_TYPE_PNG);
            // 上 右 下 左 需要留空，这个类似于 css 的 margin；这里实测 不能设置太大 超过单元格原始大小后 打开会提示修复。暂时未找到很好的解法。
            imageData.setTop(2);
            imageData.setRight(10);
            imageData.setBottom(2);
            imageData.setLeft(10);

            // * 设置图片的位置。Relative表示相对于当前的单元格index。first是左上点，last是对角线的右下点，这样确定一个图片的位置和大小。
            // 目前填充模板的图片变量是images，index：row=7,column=0。所有图片都基于此位置来设置相对位置
            // 第1张图片相对位置
            if (i == 0) {
                imageData.setRelativeFirstRowIndex(0);
                imageData.setRelativeFirstColumnIndex(0);
                imageData.setRelativeLastRowIndex(32);
                imageData.setRelativeLastColumnIndex(3);
            } else if (i == 1) {
                // 第2张图片相对位置
                imageData.setRelativeFirstRowIndex(34);
                imageData.setRelativeFirstColumnIndex(0);
                imageData.setRelativeLastRowIndex(66);
                imageData.setRelativeLastColumnIndex(3);
            } else if (i == 2) {
                // 第3张图片相对位置
                imageData.setRelativeFirstRowIndex(68);
                imageData.setRelativeFirstColumnIndex(0);
                imageData.setRelativeLastRowIndex(100);
                imageData.setRelativeLastColumnIndex(3);
            }
        }

        return writeCellData;
    }

    public static byte[] urlToByteArray(URL url) throws IOException {
        InputStream inputStream = url.openStream(); // 打开 URL 并获取 InputStream
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[4096];
        int bytesRead;
        while ((bytesRead = inputStream.read(buffer)) != -1) { // 读取 InputStream 中的数据并存储到 ByteArrayOutputStream 中
            outputStream.write(buffer, 0, bytesRead);
        }
        byte[] data = outputStream.toByteArray(); // 将 ByteArrayOutputStream 中的数据转换为 byte[]
        outputStream.close();
        inputStream.close();
        return data;
    }
}
