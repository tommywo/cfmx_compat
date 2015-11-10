package pl.wojtun.cfmxcompat;



import org.testng.Assert;
import org.testng.annotations.Test;

import pl.wojtun.cfmxcompat.coder.CoderException;

public class CFMXCompactTest{

    String key = "secretkey";
    String plain = "plain text value 1";

    String encryptedUu = "228=Z]!/-3ZGA3>F_.*5(/-TJ";
    String encryptedHex = "49877AF413CD4FA9E14DE9BF38A5483CDD2A";
    String encryptedBase64 = "SYd69BPNT6nhTem/OKVIPN0q";
    String encryptedUuDefault = "$E Z$0@";

    @Test
    public void shouldEncryptUU(){
        Assert.assertEquals(CFMXCompat.encrypt(plain, key, "uu"), encryptedUu);
        Assert.assertEquals(CFMXCompat.encrypt(plain,key),encryptedUu);

    }

    @Test
    public void shouldDecryptUU() throws CoderException {
        Assert.assertEquals(CFMXCompat.decrypt(encryptedUu, key,"uu"),plain);
        Assert.assertEquals(CFMXCompat.decrypt(encryptedUu, key),plain);

    }

    @Test
    public void shouldEncryptWithoutKey(){
        Assert.assertEquals(CFMXCompat.encrypt("test","","uu"),encryptedUuDefault);
    }

    @Test
    public void shoudEncryptHex(){
        Assert.assertEquals(CFMXCompat.encrypt(plain,key,"hex"),encryptedHex);
    }


    @Test
    public void shouldDecryptHex() throws CoderException {
        Assert.assertEquals(CFMXCompat.decrypt(encryptedHex, key,"hex"),plain);

    }

    @Test
    public void shouldEncryptBase64(){
        Assert.assertEquals(CFMXCompat.encrypt(plain,key,"base64"),encryptedBase64);
    }

    @Test
    public void shouldDecryptBase64() throws CoderException {
        Assert.assertEquals(CFMXCompat.decrypt(encryptedBase64, key,"base64"),plain);

    }

    @Test
    public void shouldReturnNull() throws CoderException {
        Assert.assertNull(CFMXCompat.decrypt("adfasarq23r","asdf","UNKNOWN"));
        Assert.assertNull(CFMXCompat.encrypt("eafasdf","sdfa","safdsa"));
    }




    @Test(expectedExceptions = CoderException.class)
    public void shouldThowExeption() throws CoderException {
        CFMXCompat.decrypt("adsasdad","key","hex");
    }

    @Test(expectedExceptions = CoderException.class)
    public void shouldThowExeptionWhenNullString() throws CoderException {
        CFMXCompat.decrypt(null,"ket","hex");
    }
    @Test(expectedExceptions = CoderException.class)
    public void shouldThowExeptionWhenNotProperHex() throws CoderException {
        CFMXCompat.decrypt("123","ket","hex");
    }
}
