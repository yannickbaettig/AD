package ch.hslu.ad.sw11_N4.Aufgabe4;

import java.io.File;
import java.util.concurrent.CountedCompleter;
import java.util.concurrent.atomic.AtomicReference;

public class FindFile extends CountedCompleter<String> {
    private String name;
    private File dir;
    private AtomicReference<String> result;

    private FindFile(CountedCompleter<String> completer, String name, File dir, AtomicReference<String> result) {
        super(completer);
        this.name = name;
        this.dir = dir;
        this.result = result;
    }

    public FindFile(String name, File dir){
        this(null, name, dir, new AtomicReference<String>(null));
    }

    @Override
    public void compute() {
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files){
                if (file.isDirectory()) {
                  this.addToPendingCount(1);
                  FindFile fileSearch =  new FindFile(this, name, file, result);
                  fileSearch.fork();
                } else if(name.equalsIgnoreCase(file.getName()) && result.compareAndSet(null, file.getParentFile().getName())){
                    this.quietlyCompleteRoot();
                }
            }
        }
        this.tryComplete();
    }

    @Override
    public String getRawResult() {
        return result.get();
    }

}
