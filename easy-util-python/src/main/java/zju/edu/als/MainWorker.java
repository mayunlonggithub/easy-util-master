package zju.edu.als;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import zju.edu.als.execption.ExecuteException;
import zju.edu.als.execption.ExecutorNotFoundExecption;
import zju.edu.als.executor.GeneralExecutor;
import zju.edu.als.executor.Python3Executor;
import zju.edu.als.executor.Python2Executor;
import zju.edu.als.factory.DefaultExecutorFactory;
import zju.edu.als.model.Test;


/**
 * @author Ma
 * @create 2019-09-13 17:31
 */
public class MainWorker {
    private static Logger log = LoggerFactory.getLogger(MainWorker.class);

    private static final String HOME = "D:/Java_develop/COVIDNet-CT/";

    public static void main(String[] args) throws ExecutorNotFoundExecption, ExecuteException {
        GeneralExecutor general = DefaultExecutorFactory.getExecutor(GeneralExecutor.class);
        /*
         */
        Python3Executor python2 = DefaultExecutorFactory.getExecutor(Python3Executor.class);
        Test test = python2.execute(Test.class, HOME + "run_covidnet_ct.py", "infer");
        log.info("将执行输出的json信息反序列化成java对象 {}.data = {}", test, test.getData());
        String s3 = python2.execute(HOME + "run_covidnet_ct.py", "infer");
        log.info("取执行输出最后一行{}", s3);

        /*
         */
        String s = general.execute("cat", HOME + "run_covidnet_ct.py");
        log.info("取执行输出最后一行 {}", s);
        String s1 = general.execute(text -> "handler:" + text, "python", HOME + "hello.py");
        log.info("取执行输出所有行，通过handler进行处理 {}", s1);

    }
}