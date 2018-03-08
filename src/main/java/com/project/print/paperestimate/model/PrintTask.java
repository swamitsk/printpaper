package com.project.print.paperestimate.model;

import java.math.BigDecimal;

public class PrintTask {

    private BigDecimal totalPagesCount;
    private BigDecimal colorPagesCount;
    private Boolean isDoubleSided;
    private PageType pageType = PageType.A2;

    public BigDecimal getTotalPagesCount() {
        return totalPagesCount;
    }

    public void setTotalPagesCount(BigDecimal totalPagesCount) {
        this.totalPagesCount = totalPagesCount;
    }

    public BigDecimal getColorPagesCount() {
        return colorPagesCount;
    }

    public void setColorPagesCount(BigDecimal colorPagesCount) {
        this.colorPagesCount = colorPagesCount;
    }

    public Boolean getDoubleSided() {
        return isDoubleSided;
    }

    public void setDoubleSided(Boolean doubleSided) {
        isDoubleSided = doubleSided;
    }

    public PageType getPageType() {
        return pageType;
    }

    public void setPageType(PageType pageType) {
        this.pageType = pageType;
    }

    @Override
    public String toString() {
        return "Page Type "+ this.pageType + " Color Count " + this.getColorPagesCount() + "Total Pages " +
                this.getTotalPagesCount() + "Is Double side" + this.getDoubleSided();
    }
}
