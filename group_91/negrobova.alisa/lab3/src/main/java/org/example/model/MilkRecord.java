package org.example.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MilkRecord {
    private LocalDate date;
    private int feedCount;
    private int milkCount;

    public MilkRecord() {
    }

    public LocalDate getDate() {
        return this.date;
    }

    public int getFeedCount() {
        return this.feedCount;
    }

    public int getMilkCount() {
        return this.milkCount;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setFeedCount(int feedCount) {
        this.feedCount = feedCount;
    }

    public void setMilkCount(int milkCount) {
        this.milkCount = milkCount;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof MilkRecord)) {
            return false;
        } else {
            MilkRecord other = (MilkRecord)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getFeedCount() != other.getFeedCount()) {
                return false;
            } else if (this.getMilkCount() != other.getMilkCount()) {
                return false;
            } else {
                Object this$date = this.getDate();
                Object other$date = other.getDate();
                if (this$date == null) {
                    if (other$date == null) {
                        return true;
                    }
                } else if (this$date.equals(other$date)) {
                    return true;
                }

                return false;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof MilkRecord;
    }

    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        result = result * 59 + this.getFeedCount();
        result = result * 59 + this.getMilkCount();
        Object $date = this.getDate();
        result = result * 59 + ($date == null ? 43 : $date.hashCode());
        return result;
    }

    public String toString() {
        String var10000 = String.valueOf(this.getDate());
        return "MilkRecord(date=" + var10000 + ", feedCount=" + this.getFeedCount() + ", milkCount=" + this.getMilkCount() + ")";
    }
}