import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.apache.dubbo.common.serialize.ObjectInput;
import org.apache.dubbo.common.serialize.ObjectOutput;
import org.apache.dubbo.common.serialize.fastjson2.FastJson2Serialization;

/**
 * Sample Application
 *
 * @author xtyuns <xtyuns@163.com>
 * @since 2023/12/13
 */
public class SampleApplication {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        List<List<Object>> data = new ArrayList<>();
        data.add(buildItem(UUID.randomUUID().toString(), BigInteger.ONE, Byte.valueOf("1")));
        data.add(buildItem(UUID.randomUUID().toString(), BigInteger.ONE, Byte.valueOf("1")));

        FastJson2Serialization serialization = new FastJson2Serialization();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutput objectOutput = serialization.serialize(null, baos);
        objectOutput.writeObject(data);
        byte[] baosByteArray = baos.toByteArray();
        System.out.println(Arrays.toString(baosByteArray));

        ByteArrayInputStream bais = new ByteArrayInputStream(baosByteArray);
        ObjectInput objectInput = serialization.deserialize(null, bais);
        Object readObject = objectInput.readObject(data.getClass());
        System.out.println(readObject);
    }

    private static List<Object> buildItem(String str, BigInteger aBigInteger, Byte aByte) {
        List<Object> item = new ArrayList<>();
        item.add(str);
        item.add(aBigInteger);
        item.add(aByte);
        return Arrays.asList(item.toArray());
    }
}
