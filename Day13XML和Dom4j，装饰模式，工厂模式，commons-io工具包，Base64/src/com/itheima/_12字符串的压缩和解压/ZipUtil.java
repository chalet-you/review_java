package com.itheima._12字符串的压缩和解压;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Base64;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class ZipUtil {
    public static void main(String[] args) {
//         String src = "H4sIAAAAAAAAAE1UTXObVhTd8yuyzybJLusuuuyiv6CLrDqTRWf6g+DZjiIxiQQ8PgSSQGAEPCQQD4GjfNmubUVxErtWK0ty7Om7xp5GKwT349xzzr2aMDHsjRw/4B6w35NHkW0Nnz7yPisbJFLJunG+0At5mRQOwdu+GHUsn/xlbhI8lJE4OSwK663+Nx46r7AH7zITYrtDzhEsJbv2zx1S5urr3l7hQ6GA5C3slUJ2iMTsYlSPDOqS770wy5WFtlaD+CC8Tq60sb2PZyWVNr6GasEMz7iImht1u53ygnvS/N7rJke8kPnqazwzmzhAL7FXDLx35ms5VgMe/frnc6NBuqO6Qwb2xIpSmU8Ckw2UTx8/ffqY8z7LoSM4JDP1peyP6j//8ezZczbAN6+X8uUcibtOvGef9QgvTCRPIwa/pX8khlPwQn/B3m6FB06Bt9pD/4hcWTqnL40tOY52MtM/L+dyiD1jq7yEUvnUovaVjryD8aB47+72j3edHonSUB6c9zXsAYKUh+gos8/ck3Ha7XG9uiakfcuK/kViWTO2K8pZqQzPgJMwwd5ADU6jDt2hLo+4W+loSKc/PXxI1t2PNMUe3Y18JOouDFXOsQeVgf6oTIKe1R9IIXVZuK209lNFjtMLHuGGmtMpB6qXUa5YDf9ob6ztYK9SHvS1FYKRyPIgw7imU13JaXu4S5UFj5yvw0NAAQre68eRNXS6B6zs2F/9y7Tri0yxwt7XWjlFYjBrjwIXgGAPCvdmfieu5SRNMyka6EtvHB/yCOTkOofdpf3CGyORXLkDGKbcHb+lU3o2zrEHzCHRehN+AnGLonNgGNYF3uYF7aqd/M9Z+imrM4okzrqBTvFxgiFUEkZ1/6jw1ZpDkn3KJjdONBWJ7F3aHaq17Ngh4HlgCPKwp950VoVvbvzL/mmhc86328WoWUp7YStyOKrzzbLoTPunPPN9od99f8ncnyvXgBkQy6Gx014g0XtH0+YptuJjICjcSBsujCGgPYQ/P3bmEUiV9quxw08W0/rO9eNUE0BoSXBNmkI6MBE00j7HRmbxSFRXjNV1931FSPDVumFOrA8YBDVn2nZWaeoQ3cu/MGm25WuHOP/k4C3wa/pSMuNGhDnqWk3aTL40paDBZAu1AomS0Dm45xkmxV6Eo1aaV8UBS6ULLN0vv/2OPfckuVDzZMEBsB+dnE8hmsXAh6iFxDAdZJKpnORT8EVFKkhY8cHssM5ycEiVGLXgqKj5LWesAowU4fEctqCyTneYT7Mxd7sqrEh7CDRAKXOt8GGCxKYymZS51SbrQldr91agLsR1apXD9CWAqQBMrvQlzAx8tQLGlv7domC+4tWQnTsQI5JchVMWbBlWrXMesVv0xPvM7o4XM6Zx627aHy0BeCcf3UFyASDBBWEMs4zfR12H3N4t6U15CX154ZZR2B/wAz3jGKOCvd87hDsF6eA6grWb281hl/euH1SFz2A6BqMRDarLX3VjO6GouULY88ZqAPggGMx5BOcbCgXJqA6HlawZlwFR87uqppGZow+MPLZog3lvmfSR2B3e94LTgD1tlkwinE9jVtchlYZ36ZnUHUKLoKXtQALbnhdyoa5GH7RaZ8X8lXIyj0SFqquWqc8Ll21s31Z49B/h0C8b0AYAAA==";
//         System.out.println(unZipAndBase64(src).length());
        String src = "H4sIAAAAAAAAAO1Vz08aURC+71/x6ok1YQFtLxBvtklPNvXQQ9M067LItsCS5eGPGP8YS0xIY1OJu1B+S8WGUgUFhNbUxIOaqD1pImkam77H7sKybKlRe3MOC2/ezDcz33wsfpp5TU+ygOG9FAfdLOelqZdWa6Me+5VrSvlivLrmIAjO6+cFCF7RUzTF8dQjzsM6jJxPWdrJCj1XqpuwDA4SAFs+GzkJJXCV4kHhVK20ECLk68dj2LVxWJZCCdmjWKOe3s01wb9NHoBoJ8lldEjFg5WLHrROU10OHKk05/MH4TgUWNrbThoLwl4nMnny9vGZwEHlaFo5Lp+v7pMyJiZPj4t9RrgdottHBddUlMp1jCmDMpqd2Ev51O/OaIjpdlNmM2g0q2uhRKWW3xWPSm+TPxup0NLytri+voHT0HIuM3uVGk6X8lulYjqaK5xKaRytBUKWOpMWV8UvUmgJhSyU8pEMBsjvFvbk8PpWYVFXOx6v/fjU1O3ZH5zwcIxmVBP+ClzoQdpFMR2uJD9cdMapntZEXChaK5+nq5thXVe9aIhRzjfZwntCQ3c/zI+xTFSPidqOpWNh46Y5HwRoX04TaQeYBRVWykf2E+sxKfk1tNC62DyJlPHRbOsLw7hp4fkLMBF0uViBtGshi5eNY5nq6P7nb7Ivs4kx5XPxMpeV77tq3QnjThgGwiDAoIVQijAeOhC4slK0dpuquYmCdD0Zqun/Kas/8g1VphvNQHEG5W+qvn6Qt/6K6nA1ynp5qw3MEZq6AUhD9DHFc07gpTmfwifqgBYmAySAboGfDoCHMwzrhxzvU7KxWSzARqlsq/uLhktJmW1tnLx+MAJ87HTrYBoYpWdtVtyRJSAwFqeH5aw2Cs7AAdKhzRyievcZ/y6tqjvF+9TGK//mLkFTTFGKqxt5mEqdJd9viXjh/Wuoumln9yly1bnuU8vizg6uh/cVWlrLiiVjKSG1onjFsEwY3snaUGWXQMkidGgCxmcDkPVSfBBSfrRIaGoJimzldAWqSEPXQBoyRBq+BtKwIdL9LiRMl07UfbBb+QhVS/YDatqNVrT9LhnD/KocY1DNuwCXCVcO8W3kIJcVj8Q33dsguvp0g85CW/AAz6XtnAT3RoDZRs51/fj/xoZbI5B5Qn4S88Qf/JLfRFYMAAA=";
        System.out.println(unZipAndBase64(src));

    }

    // 压缩  字节数组并返回压缩后的字节数组
    public static byte[] compress(byte[] bytes) {
        if (bytes == null || bytes.length == 0) {
            return bytes;
        }
        try {
            // 定义一个字节数组输出流
            // 字节数组输出流在内存中创建一个字节数组缓冲区，
            // 所有发送到输出流的数据保存在该字节数组缓冲区中
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            // 定义一个压缩流对象
            GZIPOutputStream gos = new GZIPOutputStream(bos);
            // 开始压缩原始数据 bytes 到字节数组输出流 bos 中
            gos.write(bytes);
            gos.close();
            // 返回被压缩的数据
            return bos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
            return e.getLocalizedMessage().getBytes();
        }
    }

    // 解压缩  解压字节数组并返回解压后的字节数组
    public static byte[] uncompress(byte[] bytes) {
        if (bytes == null || bytes.length == 0) {
            return bytes;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        // 定义一个字节数组输入流
        // 节数组输入流在内存中创建一个字节数组缓冲区，
        // 从输入流读取的数据保存在该字节数组缓冲区中
        ByteArrayInputStream in;
        try {

            in = new ByteArrayInputStream(bytes);
            // 定义一个解压流
            GZIPInputStream gis = new GZIPInputStream(in);
            byte[] buffer = new byte[256];
            int len;
            while ((len = gis.read(buffer)) != -1) {
                out.write(buffer, 0, len);
            }
            return out.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
            return e.getLocalizedMessage().getBytes();
        }
    }

    // TODO：压缩并编码字符串
    // 字符串 先打成字节数组后，再把字节数组压缩 再对压缩的字节数组进行Base64编码，最后把字节数组转成字符串
    public static String zipAndBase64(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        String rtnString = "";
        try {
            byte[] inputByteZip = compress(str.getBytes("GBK"));
            // 对压缩后的字节数组 inputByteZip进行 普通文本的编码后 再转换成字符串
            rtnString = new String(Base64.getEncoder().encode(inputByteZip), "GBK");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rtnString;
    }

    // TODO：解码并解压字符串
    // 已压缩的字符串进行解码，然后再解压，最后还原成最初的字符串
    public static String unZipAndBase64(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        String rtnString = "";
        try {
            byte[] bytes = Base64.getDecoder().decode(str.getBytes("GBK"));
            byte[] uncompress = uncompress(bytes);
            rtnString = new String(uncompress, "GBK");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rtnString;
    }
}
