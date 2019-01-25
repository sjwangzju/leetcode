package FB;

public class LC297SerializeAndDeserializeBinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder res = new StringBuilder();
        serializeDFS(root, res);
        return res.toString();
    }

    public void serializeDFS(TreeNode root, StringBuilder res) {
        if (root == null) {
            res.append("null ");
            return;
        }
        res.append(root.val + " ");
        serializeDFS(root.left, res);
        serializeDFS(root.right, res);
    }

    public TreeNode deserialize(String s) {
        if (s == null || s.length() == 0) return null;
        int[] index = new int[1];
        String[] strs = s.split(" ");
        return deserializeDFS(strs, index);
    }

    public TreeNode deserializeDFS(String[] strs, int[] index) {
        String cur = strs[index[0]];
        if (cur.equals("null")) {
            index[0]++;
            return null;
        }
        TreeNode tmp = new TreeNode(Integer.parseInt(cur));
        index[0]++;
        tmp.left = deserializeDFS(strs, index);
        tmp.right = deserializeDFS(strs, index);
        return tmp;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t21 = new TreeNode(2);
        TreeNode t22 = new TreeNode(3);
        TreeNode t31 = new TreeNode(4);
        TreeNode t32 = new TreeNode(5);
        t1.left = t21; t1.right = t22;
        t22.left = t31; t22.right = t32;
        String s = new LC297SerializeAndDeserializeBinaryTree().serialize(t1);
        System.out.println(s);
        TreeNode t = new LC297SerializeAndDeserializeBinaryTree().deserialize(s);
        System.out.println(t.val);
    }
}
