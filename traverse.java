import java.util.*;

public class traverse {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            while (sc.hasNext()) {
                String s = sc.nextLine();
                TreeNode root = buildTree(s);
                levelOrderTraversal(root);
            }
        }

        public static TreeNode buildTree(String s) {
            String[] values = s.split(" "); // 根据空格分割输入字符串
            if (values.length == 0) {
                return null;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            TreeNode root = new TreeNode(Integer.parseInt(values[0]));
            queue.offer(root);
            int i = 1;

            while (!queue.isEmpty() && i < values.length) {
                TreeNode current = queue.poll();
                String leftValue = values[i++];
                if (!leftValue.equals("null")) {
                    current.left = new TreeNode(Integer.parseInt(leftValue));
                    queue.offer(current.left);
                }

                if (i < values.length) {
                    String rightValue = values[i++];
                    if (!rightValue.equals("null")) {
                        current.right = new TreeNode(Integer.parseInt(rightValue));
                        queue.offer(current.right);
                    }
                }
            }

            return root;
        }

        public static void levelOrderTraversal(TreeNode root) {
            if (root == null) {
                return;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                TreeNode current = queue.poll();
                System.out.print(current.val + " ");

                if (current.left != null) {
                    queue.offer(current.left);
                }

                if (current.right != null) {
                    queue.offer(current.right);
                }
            }

            System.out.println();
        }
    }

