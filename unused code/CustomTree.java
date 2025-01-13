    import java.util.ArrayList;

    public class CustomTree {
        public String nodeName;
        private ArrayList childNodes;
        private ArrayList childNodesName;

        // i could change this implementation to use a dict insted

        public  CustomTree(String nodeName){
            this.nodeName = nodeName;
            this.childNodes = new ArrayList<Object>();
            this.childNodesName = new ArrayList<String>();
        }

        public Object getChildNodeByName(String nodeName){
            // TODO find out what happen when the dam thing dose not found the node
            int index = this.childNodesName.indexOf(nodeName);
            return this.childNodes.get(index);
        }

        public void addChildNode(String nodeName, Object o){
            // check if the nodeName is unqueue or not
            if (this.childNodesName.contains(nodeName) == true){
                System.out.println("node name not unqueue");
                return;
            }
            this.childNodesName.add(nodeName);
            this.childNodes.add(o);
        }

        public Object popChildNode(String nodeName){
            if (!this.childNodesName.contains(nodeName)){
                System.out.println("No node with that name found");
                return null;
            }
            int index = this.childNodesName.indexOf(nodeName);
            return this.childNodes.get(index);
        }

        public int getNodeIndex(String nodeName){
            return this.childNodesName.indexOf(nodeName);
        }

        //ToDo implement insert at index node later


    }
