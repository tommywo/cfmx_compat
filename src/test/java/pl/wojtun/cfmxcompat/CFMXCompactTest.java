package pl.wojtun.cfmxcompat;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CFMXCompactTest{

    CFMXCompat cfmxCompat = new CFMXCompat();

    String key = "secretkey";
    String plain = "plain text value 1";

    String encryptedUu = "228=Z]!/-3ZGA3>F_.*5(/-TJ";
    String encryptedHex = "49877AF413CD4FA9E14DE9BF38A5483CDD2A";
    String encryptedBase64 = "SYd69BPNT6nhTem/OKVIPN0q";

    @Test
    public void shouldEncryptUU(){
        Assert.assertEquals(cfmxCompat.encrypt(plain,key,"uu"),encryptedUu);
        Assert.assertEquals(cfmxCompat.encrypt(plain,key),encryptedUu);

    }

    @Test
    public void shouldDecryptUU(){
        Assert.assertEquals(cfmxCompat.decrypt(encryptedUu, key,"uu"),plain);
        Assert.assertEquals(cfmxCompat.decrypt(encryptedUu, key),plain);

    }

    @Test
    public void shoudEncryptHex(){
        Assert.assertEquals(cfmxCompat.encrypt(plain,key,"hex"),encryptedHex);
    }


    @Test
    public void shouldDecryptHex(){
        Assert.assertEquals(cfmxCompat.decrypt(encryptedHex, key,"hex"),plain);

    }

    @Test
    public void shouldEncryptBase64(){
        Assert.assertEquals(cfmxCompat.encrypt(plain,key,"base64"),encryptedBase64);
    }

    @Test
    public void shouldDecryptBase64(){
        Assert.assertEquals(cfmxCompat.decrypt(encryptedBase64, key,"base64"),plain);

    }
}
