package com.chenjw.demo;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;

import javax.annotation.Resource;
import java.io.*;
import java.util.Scanner;

public class Demo {

    @Resource
    private ProcessEngine processEngine;

    @Resource
    private RepositoryService repositoryService;

    @Resource
    private RuntimeService runtimeService;

    @Resource
    private TaskService taskService;

    public void initActiviti(){

        Deployment deploy = repositoryService.createDeployment().addClasspathResource("activiti/qjlc.bpmn20.xml").deploy();

        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().deploymentId(deploy.getId()).singleResult();

        ProcessInstance processInstance = runtimeService.startProcessInstanceById(processDefinition.getId());

//        String businessKey = processInstance.getBusinessKey();

        TaskQuery taskQuery = taskService.createTaskQuery().processDefinitionId(processDefinition.getId());

        Task task = taskQuery.taskAssignee("请假人xx").singleResult();

        taskService.complete(task.getId());


    }

//    public static void main(String[] args) {
//        Integer[] a = new Integer[]{1,2,3};
//
//        System.out.println(a.length);
//
//        for(int i=0 ;i<a.length;i++){
//            a[i] = null;
//        }
//        System.out.println(a.length);
//
//        int[] arr = sort();
//        for (int num :arr){
//            System.out.print(num);
//        }
//    }

    public static void main(String[] args) {
        OutputStream fileOutputStream = null;
        InputStream inputStream = null;
        try {
            File file = new File("C:\\Users\\86158\\Desktop\\test2.md");
            if(!file.exists()){
                file.createNewFile();
            }
            fileOutputStream = new FileOutputStream(file);

            String str = "测试往test.md中写入数据。。。。。。。。。。。。";
            byte[] bytes = str.getBytes("utf-8");
            int offset = 0;
            int length;
            while (offset < bytes.length) {
                length = Math.min(1024, bytes.length - offset);
                fileOutputStream.write(bytes, offset, length);
                offset += length;
            }

            inputStream = new FileInputStream(file);
            byte[] bytes1 = new byte[1024];
            inputStream.read(bytes1);

            String string = new String(bytes1, "utf-8");

            System.out.println(string);

            Scanner scanner = new Scanner(System.in);
            String next = scanner.next();
            System.out.println(next);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(fileOutputStream != null){
                    fileOutputStream.flush();
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


    /**
     * 对数组进行冒泡排序。
     * 冒泡排序是一种简单的排序算法，它重复地走访过要排序的数列，一次比较两个元素，如果他们的顺序错误就把他们交换过来。
     * 走访数列的工作是重复地进行直到没有再需要交换，也就是说该数列已经排序完成。
     *
     * @return 排序后的整型数组。
     */
    public static int[] sort(){
        int[] arr = new int[]{8,5,3,1,2};

        for (int i=0; i < arr.length -1; i++){
            for (int j = 0; j < arr.length - i - 1; j++){
                if(arr[j] > arr[j + 1]){
                    int t = arr[j];
                    arr[j] = arr[j +1];
                    arr[j + 1] = t;
                }
            }
        }

        return arr;

    }
}
