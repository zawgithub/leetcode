package leetcode.tree;

/**
 * @Author: zhaoanwei
 * @Date: 2021/3/10
 */
public class 序列化和反序列化二叉搜索树_449 {
//    示例 1：
//    输入：root = [2,1,3]
//    输出：[2,1,3]
//
//    示例 2：
//    输入：root = []
//    输出：[]
//             
//    提示：
//    树中节点数范围是 [0, 10^4]
//            0 <= Node.val <= 10^4
//    题目数据 保证 输入的树是一棵二叉搜索树。

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // Encodes a tree to a single string.
    private static StringBuilder s = new StringBuilder();
    public static String serialize(TreeNode root) {
        //先序遍历, 根->左子->右子
        preOrder(root);
        return s.toString();
    }
    private static void preOrder(TreeNode root){
        if (root==null) return;
        s.append(root.val).append(",");
        preOrder(root.left);
        preOrder(root.right);
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if ("".equals(data)) return null;
        String[] strings = data.split(",");
        return buildTree(strings, 0, strings.length-1);
    }

    private static TreeNode buildTree(String[] strings, int l, int r) {
        if (l>r) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(strings[l]));
        if (l==r) {
            return root;
        }
        //确定左右子树范围
        int i = l+1;
        for (;i<=r;i++) {
            if (Integer.parseInt(strings[i])>root.val) {
                break;
            }
        }
        root.left = buildTree(strings, l+1, i-1);
        root.right = buildTree(strings, i, r);
        return root;
    }

    public static void main(String[] args) {
        TreeNode deserialize = deserialize("2,1");
    }
}
