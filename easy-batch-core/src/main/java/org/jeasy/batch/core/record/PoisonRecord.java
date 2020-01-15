/**
 * The MIT License
 *
 *   Copyright (c) 2020, Mahmoud Ben Hassine (mahmoud.benhassine@icloud.com)
 *
 *   Permission is hereby granted, free of charge, to any person obtaining a copy
 *   of this software and associated documentation files (the "Software"), to deal
 *   in the Software without restriction, including without limitation the rights
 *   to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *   copies of the Software, and to permit persons to whom the Software is
 *   furnished to do so, subject to the following conditions:
 *
 *   The above copyright notice and this permission notice shall be included in
 *   all copies or substantial portions of the Software.
 *
 *   THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *   IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *   FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *   AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *   LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *   OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 *   THE SOFTWARE.
 */
package org.jeasy.batch.core.record;

import java.io.Serializable;
import java.util.Date;

/**
 * A marker record that serves as End-Of-Stream record or Poison Record.
 * This is useful to mark the end of reading in a queue based record pulling system.
 *
 * @author Mahmoud Ben Hassine (mahmoud.benhassine@icloud.com)
 *
 * @deprecated This class is deprecated since v5.3 and will be removed in v6.
 */
@Deprecated
public class PoisonRecord implements Record<Object>, Serializable {

    @Override
    public Header getHeader() {
        return new Header(0L, "Poison record", new Date());
    }

    @Override
    public Object getPayload() {
        return new Object();
    }

    @Override
    public String toString() {
        return "Poison Record";
    }

    /**
     * Check if a record is a {@link PoisonRecord}.
     *
     * @param record to check
     * @return true if the record is a poison record, false otherwise
     */
    public static boolean isPoisonRecord(final Record record) {
        return record instanceof PoisonRecord;
    }

}