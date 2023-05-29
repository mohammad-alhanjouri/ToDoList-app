public class Task {
    // create private variables with getters and setters

    private int id;
    private String title;
    private boolean isCompleted;
    private Date dueDate;

    public Task(int id,String title, boolean isCompleted, Date dueDate){
        this.id= id;
        this.title= title;
        this.isCompleted= isCompleted;
        this.dueDate= dueDate;
    }
    public int getID() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public void markAsCompleted() {
        isCompleted = true;
    }
}
