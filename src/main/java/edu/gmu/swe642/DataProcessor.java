package edu.gmu.swe642;

public class DataProcessor {
    DataBean dataBean = new DataBean();
    

    public DataProcessor(){
    }

    public DataBean computeMeanAndDeviation(int[] userNumbers ){

        int length = userNumbers.length;
        double sum = 0.0;
        double standardDeviation = 0.0;

        for(double num : userNumbers) {
            sum += num;
        }

        double mean = sum/length;
        this.dataBean.setMean(mean);

        for(double num: userNumbers) {
            standardDeviation += Math.pow(num - mean, 2);
        }

        double deviation = Math.sqrt(standardDeviation/length);
        this.dataBean.setStandardDev(deviation);
        return this.dataBean;
    }

}
