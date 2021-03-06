package org.fenixedu.commons.spreadsheet.styles;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Workbook;

public class FontColor extends SpreadsheetCellStyle {

    private final IndexedColors color;

    public FontColor(IndexedColors color) {
        this.color = color;
    }

    @Override
    protected void appendToStyle(Workbook book, CellStyle style, Font font) {
        font.setColor(color.getIndex());
    }

    @Override
    public CellStyle getStyle(Workbook book) {
        CellStyle style = book.createCellStyle();
        Font font = book.createFont();
        appendToStyle(book, style, font);
        style.setFont(font);
        return style;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof FontColor) {
            FontColor fontColor = (FontColor) obj;
            return color.equals(fontColor.color);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return color.hashCode();
    }
}
