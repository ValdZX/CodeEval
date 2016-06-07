package codeeval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class WorkingExperience {
    public static void main(String[] args) throws IOException, ParseException {
        SimpleDateFormat format = new SimpleDateFormat("MMM yyyy", Locale.ENGLISH);
        File file = new File(args[0]);
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        while ((line = in.readLine()) != null) {
            String[] periodsStrs = line.split("; ");
            List<Period> periods = new ArrayList<Period>();
            for (String periodStr : periodsStrs) {
                String[] subPeriod = periodStr.split("-");
                String dateFromStr = subPeriod[0];
                long dateFromTime = format.parse(dateFromStr).getTime();
                String dateToStr = subPeriod[1];
                Date dateTo = format.parse(dateToStr);
                dateTo.setMonth(dateTo.getMonth() + 1);
                dateTo.setDate(dateTo.getDate() - 1);
                long dateToTime = dateTo.getTime();
                Period newPeriod = new Period(dateFromTime, dateToTime);

                if(addToArray(newPeriod, periods)){
                    if(periods.size() > 1){
                        List<Period> newPeriods = new ArrayList<Period>();
                        for (Period period : periods) {
                            addToArray(period, newPeriods);
                        }
                    }
                }
            }

            long result = 0;
            for (Period period : periods) {
                result += period.getTo() - period.getFrom();
            }
            int years = new Date(result).getYear() - new Date(0).getYear();
            System.out.println(years);
        }
    }

    private static boolean addToArray(Period addedPeriod, List<Period> periods) {
        if (periods.isEmpty()) {
            periods.add(addedPeriod);
        } else {
            boolean add = false;
            for (Period period : periods) {
                if (period.getFrom() <= addedPeriod.getFrom() && period.getTo() >= addedPeriod.getTo()) {
                    return false;
                }
                if (period.getFrom() <= addedPeriod.getFrom() && period.getTo() >= addedPeriod.getFrom() && addedPeriod.getTo() > period.getTo()) {
                    period.setTo(addedPeriod.getTo());
                    return false;
                }
                if (period.getFrom() <= addedPeriod.getTo() && period.getTo() >= addedPeriod.getTo() && addedPeriod.getFrom() < period.getFrom()) {
                    period.setFrom(addedPeriod.getFrom());
                    return false;
                }
                if (period.getFrom() >= addedPeriod.getFrom() && period.getTo() <= addedPeriod.getTo()) {
                    period.setFrom(addedPeriod.getFrom());
                    period.setTo(addedPeriod.getTo());
                    return false;
                }
            }
            periods.add(addedPeriod);
        }
        return true;
    }

    private static class Period {
        protected long from;
        protected long to;

        public Period(long from, long to) {
            this.from = from;
            this.to = to;
        }

        public long getFrom() {
            return from;
        }

        public void setFrom(long from) {
            this.from = from;
        }

        public long getTo() {
            return to;
        }

        public void setTo(long to) {
            this.to = to;
        }
    }
}
