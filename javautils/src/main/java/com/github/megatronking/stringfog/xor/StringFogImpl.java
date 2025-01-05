package com.github.megatronking.stringfog.xor;

import com.github.megatronking.stringfog.IStringFog;


import java.nio.charset.StandardCharsets;

public final class StringFogImpl implements IStringFog {
    private static byte[] xor(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
        int i = paramArrayOfbyte1.length;
        int j;
        byte b1, b2;
        for (j = paramArrayOfbyte2.length, b1 = 0, b2 = 0; b1 < i; ) {
            if (b2 >= j) b2 = 0;
            paramArrayOfbyte1[b1] =

                    (byte) (paramArrayOfbyte1[b1] ^ paramArrayOfbyte2[b2]);
            b1++;
            b2++;
        }
        return paramArrayOfbyte1;
    }

    public byte[] encrypt(String paramString, byte[] paramArrayOfbyte) {
        return xor(paramString.getBytes(StandardCharsets.UTF_8), paramArrayOfbyte);
    }

    public String decrypt(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
        return new String(xor(paramArrayOfbyte1, paramArrayOfbyte2), StandardCharsets.UTF_8);
    }

    public boolean shouldFog(String paramString) {
        return true;
    }
}
