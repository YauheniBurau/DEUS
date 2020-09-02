package newWorkflowFx

import newGui.NotificationsFxFactory

class WorkflowIO {
    private File file;

    WorkflowIO() {
        this.file = null;
    }

    File getFile() {
        return file
    }

    void setFile(File file) {
        this.file = file
    }

    /**
     * load file *.wfs and deserialize to workflowFx object
     *
     * @param file
     * @return
     */
    static WorkflowFx loadWorkflow(File file){
        WorkflowFx workflowFx = null
        try {
            FileInputStream fileInputStream = new FileInputStream(file.getAbsolutePath())
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)
            workflowFx = (WorkflowFx) objectInputStream.readObject()
            objectInputStream.close()
        } catch (IOException e) {
            NotificationsFxFactory.showError(
                    "load file *.wfs and deserialize to workflowModel object", e.getMessage(), e)
        } catch (ClassNotFoundException e) {
            NotificationsFxFactory.showError(
                    "load file *.wfs and deserialize to workflowModel object", e.getMessage(), e)
        }
        return workflowFx
    }

    /**
     * serialize and save workflowFx object to File *.wfs
     * @param workflowModel
     * @param file
     * @return
     */
    static File saveWorkflow(WorkflowFx workflowFx, File file){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file.getAbsolutePath())
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)
            objectOutputStream.writeObject(workflowFx)
            objectOutputStream.close()
        } catch (IOException e) {
            NotificationsFxFactory.showError(
                    "serialize and save workflowFx object to File *.wfs", e.getMessage(), e)
        }
        return file
    }

    /**
     * load file *.wfv and deserialize to WVertexFx object
     *
     * @param file
     * @return
     */
    static WVertexFx loadWorkflowVertex(File file){
        WVertexFx workflowVertex = null
        try {
            FileInputStream fileInputStream = new FileInputStream(file.getAbsolutePath())
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)
            workflowVertex = (WVertexFx) objectInputStream.readObject()
            objectInputStream.close();
        } catch (IOException e) {
            NotificationsFxFactory.showError(
                    "load file *.wfv and deserialize to WVertexFx object", e.getMessage(), e)
        } catch (ClassNotFoundException e) {
            NotificationsFxFactory.showError(
                    "load file *.wfv and deserialize to WVertexFx object", e.getMessage(), e)
        }
        return workflowVertex
    }

    /**
     * serialize and save WVertexFx object to File *.wfv
     * @param workflowVertex
     * @param file
     * @return
     */
    static File saveWorkflowVertex(WVertexFx workflowVertex, File file){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file.getAbsolutePath())
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)
            objectOutputStream.writeObject(workflowVertex)
            objectOutputStream.close()
        } catch (IOException e) {
            NotificationsFxFactory.showError(
                    "serialize and save WVertexFx object to File *.wfv", e.getMessage(), e);
        }
        return file
    }

}
