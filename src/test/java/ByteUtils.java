public class ByteUtils {

    public static void main(String[] args) {
        byte[] bytes = int2Bytes(109, 5);
        int rnt = bytes2Int(bytes, 0, bytes.length);
        System.out.println(rnt);



        // rand3 - {1,2,3}  81
        // rand3*rand3*rand3*rand3 + (rand3-1)*rand3 + rand3-1
    }

    public static byte[] int2Bytes(int value, int len){
        byte[] bytes = new byte[len];
        for (int i = 0; i < len; i++) {
            bytes[len -i -1] = (byte) ((value >> 8*i) & 0xff);
        }
        return bytes;
    }

    public static int bytes2Int(byte[] b, int start, int len){
        int sum = 0;
        int end = start+len;
        for (int i = start; i < end; i++) {
            int n = ((int) b[i]) & 0xff;
            n <<= (--len);
            sum += n;
        }
        return sum;
    }

}
