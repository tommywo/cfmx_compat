package pl.wojtun.cfmxcompat;


import org.junit.Assert;
import org.junit.Test;

import pl.wojtun.cfmxcompat.coder.CoderException;

public class CFMXCompactTest{

    CFMXCompat cfmxCompat = new CFMXCompat();

    String key = "secretkey";
    String plain = "plain text value 1";

    String encryptedUu = "228=Z]!/-3ZGA3>F_.*5(/-TJ";
    String encryptedHex = "49877AF413CD4FA9E14DE9BF38A5483CDD2A";
    String encryptedBase64 = "SYd69BPNT6nhTem/OKVIPN0q";
    String encryptedUuDefault = "$E Z$0@";

    @Test
    public void shouldEncryptUU(){
        Assert.assertEquals(cfmxCompat.encrypt(plain, key, "uu"), encryptedUu);
        Assert.assertEquals(cfmxCompat.encrypt(plain,key),encryptedUu);

    }

    @Test
    public void shouldDecryptUU() throws CoderException {
        Assert.assertEquals(cfmxCompat.decrypt(encryptedUu, key,"uu"),plain);
        Assert.assertEquals(cfmxCompat.decrypt(encryptedUu, key),plain);

    }

    @Test
    public void shouldEncryptWithoutKey(){
        Assert.assertEquals(cfmxCompat.encrypt("test","","uu"),encryptedUuDefault);
    }

    @Test
    public void shoudEncryptHex(){
        Assert.assertEquals(cfmxCompat.encrypt(plain,key,"hex"),encryptedHex);
    }


    @Test
    public void shouldDecryptHex() throws CoderException {
        Assert.assertEquals(cfmxCompat.decrypt(encryptedHex, key,"hex"),plain);

    }

    @Test
    public void shouldEncryptBase64(){
        Assert.assertEquals(cfmxCompat.encrypt(plain,key,"base64"),encryptedBase64);
    }

    @Test
    public void shouldDecryptBase64() throws CoderException {
        Assert.assertEquals(cfmxCompat.decrypt(encryptedBase64, key,"base64"),plain);

    }

    @Test
    public void shouldReturnNull() throws CoderException {
        Assert.assertNull(cfmxCompat.decrypt("adfasarq23r","asdf","UNKNOWN"));
        Assert.assertNull(cfmxCompat.encrypt("eafasdf","sdfa","safdsa"));
    }




    @Test(expected = CoderException.class)
    public void shouldThowExeption() throws CoderException {
        cfmxCompat.decrypt("adsasdad","key","hex");
    }

    @Test(expected = CoderException.class)
    public void shouldThowExeptionWhenNullString() throws CoderException {
        cfmxCompat.decrypt(null,"ket","hex");
    }
    @Test(expected = CoderException.class)
    public void shouldThowExeptionWhenNotProperHex() throws CoderException {
        cfmxCompat.decrypt("123","ket","hex");
    }
}
