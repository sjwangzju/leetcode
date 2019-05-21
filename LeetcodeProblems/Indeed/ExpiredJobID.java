package Indeed;

//  You are given a list of jobs, each job has an ID number(type is long). Implement two functions,
//  1.expire(long jobid) to set a job as "expired"
//  2.isexpired(long jobid) to check if a job is "expired"

import java.util.LinkedList;
import java.util.List;

public class ExpiredJobID {

    public class Interval {
        long start;
        long end;

        public Interval(long start, long end) {
            this.start = start;
            this.end = end;
        }
    }

    List<Interval> list;
    public ExpiredJobID() {
        this.list = new LinkedList<>();
    }

    public void expire(long jobid) {
        if (list.size() == 0) {
            list.add(new Interval(jobid, jobid));
            return;
        }
        if (jobid < list.get(0).start) {
            if (jobid == list.get(0).start - 1) {
                list.get(0).start = jobid;
            } else {
                list.add(0, new Interval(jobid, jobid));
            }
        } else if (jobid > list.get(list.size() - 1).end) {
            if (jobid == list.get(list.size() - 1).end + 1) {
                list.get(list.size() - 1).end = jobid;
            } else {
                list.add(new Interval(jobid, jobid));
            }
        } else {
            for (int i = 0; i < list.size(); i++) {
                Interval cur = list.get(i);
                if (jobid >= cur.start && jobid <= cur.end) {
                    return;
                } else if (i < list.size() - 1 && jobid > cur.end && jobid < list.get(i + 1).start) {
                    if (jobid == cur.end + 1 && jobid == list.get(i + 1).start - 1) {
                        cur.end = list.get(i + 1).end;
                        list.remove(i + 1);
                    } else if (jobid == cur.end + 1) {
                        cur.end = jobid;
                    } else if (jobid == list.get(i + 1).start - 1) {
                        list.get(i + 1).start = jobid;
                    } else {
                        list.add(new Interval(jobid, jobid));
                    }
                }
            }
        }
    }

    public boolean isExpired(long jobid) {
        for (int i = 0; i < list.size(); i++) {
            if (jobid >= list.get(i).start && jobid <= list.get(i).end) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ExpiredJobID expiredJobID = new ExpiredJobID();
        expiredJobID.expire(198);
        expiredJobID.expire(200);
        expiredJobID.expire(201);
        expiredJobID.expire(202);
        expiredJobID.expire(199);
        System.out.println(expiredJobID.isExpired(199));
    }
}
