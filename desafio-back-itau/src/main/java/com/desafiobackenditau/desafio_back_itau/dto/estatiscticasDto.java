package com.desafiobackenditau.desafio_back_itau.dto;

public class estatiscticasDto {
    private double count;
    private double sum;
    private double avg;
    private double min;
    private double max;

    public void setCount(double count){
        this.count = count;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public void setAvg(double avg){
        this.avg = avg;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public double getCount() {
        return count;
    }

    public double getAvg() {
        return avg;
    }

    public double getSum() {
        return sum;
    }

    public double getMin() {
        return min;
    }

    public double getMax() {
        return max;
    }

    public estatiscticasDto(){};

    public estatiscticasDto(double count,double sum, double avg, double min, double max){
        this.count = count;
        this.sum = sum;
        this.avg = avg;
        this.min = min;
        this.max = max;

    }
}
