import java.util.*;

import java.util.*;

public class DSExercise5 {
    public static void main(String[] args){
        Tasks taskList = new Tasks();
        taskList.add(new Task(1, "Complete Assignment", "Pending"));
        taskList.add(new Task(2, "Study for Exam", "In Progress"));
        taskList.add(new Task(3, "Read Book", "Pending"));
        taskList.add(new Task(4, "Submit Report", "Done"));

        taskList.traverse();

        Task result = taskList.search(2);
        System.out.println("Search Result: " + result);

        taskList.delete(1);

        taskList.traverse();
    }
}


class Tasks{
    Task head;
    public void add(Task task){
        if(head==null){
            head=task;
        }
        else{
            Task curr=head;
            while(curr.next!=null){
                curr=curr.next;
            }
            curr.next=task;
        }
    }
    public Task search(int taskId){
        Task curr=head;
        while(curr!=null){
            if(curr.getTaskId()==taskId){
                return curr;
            }
            curr=curr.next;
        }
        return null;
    }
    public void traverse(){
        Task curr=head;
        System.out.println("Displaying Tasks...");
        while(curr!=null){
            System.out.println(curr);
            curr=curr.next;
        }
    }
    public void delete(int taskId){
        if(head==null){
            return;
        }
        if(head.getTaskId()==taskId){
            head=head.next;
        }
        Task curr=head;
        while(curr.next!=null && curr.next.getTaskId()!=taskId){
            curr=curr.next;
        }
        if(curr.next!=null){
            curr.next=curr.next.next;
        }
        System.out.println("Deleted successfully");
    }
}
class Task{
    private int taskId;
    private String taskName;
    private String status;
    Task next;
    public Task(int tid,String tn, String st){
        taskId=tid;
        taskName=tn;
        status=st;
        next=null;
    }
    public int getTaskId(){
        return taskId;
    }
    public String getTaskName(){
        return taskName;
    }
    public String getStatus(){
        return status;
    }
    @Override
    public String toString(){
        return "ID: "+taskId+", Name: "+taskName+", Status: "+status;
    }
}
