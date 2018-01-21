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

package com.github.strka.realconvert.unit.length;

import com.github.strka.realconvert.BigDecimalBuilder;
import com.github.strka.realconvert.unit.Length;
import java.math.BigDecimal;

public class Inch extends Length {

  private static final BigDecimal INCH_CONST = BigDecimalBuilder.getInstance().build(0.0254);

  public Inch(double value) {
    this.name = "inch";
    this.symbol = "in";
    this.value = BigDecimalBuilder.getInstance().build(value);
  }

  public Inch(BigDecimal value) {
    this.name = "inch";
    this.symbol = "in";
    this.value = value;
  }

  @Override
  public Metre normalize() {
    return new Metre(
        this.getValue().multiply(INCH_CONST, BigDecimalBuilder.getInstance().getMathContext()));
  }

  @Override
  public Inch from(Metre standardUnit) {
    return new Inch(standardUnit.getValue()
        .divide(INCH_CONST, BigDecimalBuilder.getInstance().getMathContext()));
  }
}