/*
 * Copyright (C) 2017, Megatron King
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.github.megatronking.stringfog;

import java.lang.reflect.InvocationTargetException;

/**
 * A wrapper for the real implementation of fogs.
 *
 * @author Megatron King
 * @since 2018/9/20 16:14
 */
public final class StringFogWrapper implements IStringFog {

    private final IStringFog mStringFogImpl;

    public StringFogWrapper(String impl) {
        try {
            mStringFogImpl = (IStringFog) Class.forName(impl).getDeclaredConstructor().newInstance();
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException("Stringfog implementation class not found: " + impl);
        } catch (InstantiationException e) {
            throw new IllegalArgumentException("Stringfog implementation class new instance failed: "
                    + e.getMessage());
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new IllegalArgumentException("Stringfog implementation class create instance failed: "
                    + e.getMessage());
        }
    }

    @Override
    public byte[] encrypt(String data, byte[] key) {
        return mStringFogImpl == null ? data.getBytes() : mStringFogImpl.encrypt(data, key);
    }

    @Override
    public String decrypt(byte[] data, byte[] key) {
        return mStringFogImpl == null ? new String(data) : mStringFogImpl.decrypt(data, key);
    }

    @Override
    public boolean shouldFog(String data) {
        return mStringFogImpl != null && mStringFogImpl.shouldFog(data);
    }

}