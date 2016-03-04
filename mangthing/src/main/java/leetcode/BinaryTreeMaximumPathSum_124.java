package leetcode;

/**
 * Created by Fangshuai on 2016/3/4.
 * 节点可能为负数，寻找一条最路径使得所经过节点和最大。路径可以开始和结束于任何节点但是不能走回头路。
 * 这道题虽然看起来不同寻常，但是想一下，可以发现不外乎二叉树的遍历+简单的动态规划思想。
 * 我们可以把问题拆分开：即便最后的最大路径没有经过根节点，它必然也有自己的“最高点”，因此我们只要针对所有结点，求出：如果路径把这个节点作为“最高点”，路径最长可达多少？记为max。然后在max中求出最大值MAX即为所求结果。和“求整数序列中的最大连续子序列”一样思路。
 * 下面就是找各个“最高点”对应的max之间的关系了。
 * 我们拿根节点为例，对于经过根节点的最大路径的计算方式为：
 * 我们找出左子树中以左孩子为起点的最大路径长度a，和右子树中以右孩子为起点的最大路径长度b。然后这个点的 max = MAX(a+b+node.val, a+node.val, b+node.val, node.val)
 * 因此我们定义一个函数来算上面的a或者b，它的参数是一个节点，它的返回值是最大路径长度，但是这个路径的起点必须是输入节点，而且路径必须在以起点为根节点的子树上。
 * 那么函数func(node)的return值可以这样定义：return MAX(func(node.left)+node.val, func(node.right)+node.val, node.val)
 * 终止条件是node == null，直接返回0。
 */
public class BinaryTreeMaximumPathSum_124 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int i) {
            val = i;
        }
    }

    private int max = -9999;

    public int childPathSum(TreeNode node) {
        if (node == null) return 0;
        int leftMax = childPathSum(node.left);
        int rightMax = childPathSum(node.right);
        if (leftMax + rightMax + node.val > max) max = leftMax + rightMax + node.val;
        if (leftMax + node.val > max) max = leftMax + node.val;
        if (rightMax + node.val > max) max = rightMax + node.val;
        if (node.val > max) max = node.val;
        int thisMax = (rightMax + node.val > node.val) ? rightMax + node.val : node.val;
        return thisMax > leftMax + node.val ? thisMax : leftMax + node.val;
    }

    public int maxPathSum(TreeNode root) {
        childPathSum(root);
        return max;
    }
}
