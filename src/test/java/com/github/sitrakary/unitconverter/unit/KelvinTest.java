/*
 * MIT License
 *
 * Copyright (c) 2018 Sitraka Ratsimba
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.github.sitrakary.unitconverter.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.github.sitrakary.unitconverter.unit.temperature.Kelvin;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class KelvinTest {

  Kelvin kelvin;

  @Before
  public void setUp() {
    kelvin = new Kelvin(4d);
  }

  @After
  public void tearDown() {
  }

  @Test
  public void shouldHaveNameAndSymbol() {
    assertNotNull(kelvin.getName());
    assertNotNull(kelvin.getSymbol());
  }

  @Test
  public void normalizeShouldReturnAKelvinTemperature() {
    assertEquals(0, kelvin.normalize().getValue().compareTo(kelvin.getValue()));
  }

  @Test
  public void fromShouldReturnKelvinFromNormalizedUnit() {
    Kelvin createdKelvin = kelvin.from(kelvin);
    assertEquals(0, kelvin.getValue().compareTo(createdKelvin.getValue()));
  }

  @Test
  public void shouldHaveTemperatureType() {
    assertNotNull(kelvin.getType());
  }
}