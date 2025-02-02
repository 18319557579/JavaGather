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

/**
 * Interface of how to encrypt and decrypt a string.
 *
 * @author Megatron King
 * @since 2018/9/20 16:15
 */
public interface IStringFog {

  /**
   * Encrypt the data by the special key.
   *
   * @param data The original data.
   * @param key Encrypt key.
   * @return The encrypted data.
   */
  byte[] encrypt(String data, byte[] key);

  /**
   * Decrypt the data to origin by the special key.
   *
   * @param data The encrypted data.
   * @param key Encrypt key.
   * @return The original data.
   */
  String decrypt(byte[] data, byte[] key);

  /**
   * Whether the string should be encrypted.
   *
   * @param data The original data.
   * @return If you want to skip this String, return false.
   */
  boolean shouldFog(String data);

}