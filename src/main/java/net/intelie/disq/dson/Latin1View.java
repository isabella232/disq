package net.intelie.disq.dson;

import javax.print.DocFlavor;
import java.util.Locale;

public class Latin1View implements CharSequence {
    private StringBuilder builder;
    private byte[] buf;
    private int start;
    private int length;

    public void set(byte[] buf, int start, int length) {
        this.buf = buf;
        this.start = start;
        this.length = length;
    }

    @Override
    public int length() {
        return length;
    }

    @Override
    public char charAt(int i) {
        return (char) (buf[start + i] & 0xFF);
    }

    @Override
    public Latin1View subSequence(int startIndex, int endIndex) {
        Latin1View view = new Latin1View();
        subSequence(startIndex, endIndex, view);
        return view;
    }

    public void subSequence(int startIndex, int endIndex, Latin1View target) {
        target.set(buf, start + startIndex, endIndex - startIndex);
    }

    @Override
    public String toString() {
        if (builder == null) {
            builder = new StringBuilder(length);
        } else {
            builder.ensureCapacity(length);
            builder.setLength(0);
        }
        return builder.append(this).toString();
    }
}