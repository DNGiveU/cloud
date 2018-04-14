package com.ngiveu.cloud.admin.common.util;


import java.util.ArrayList;
import java.util.List;

import com.ngiveu.cloud.admin.model.dto.TreeNode;

/**
 * @author lengleng
 * @date 2017年11月9日23:34:11
 */
public class TreeUtil {
    /**
     * 两层循环实现建树
     *
     * @param treeNodes 传入的树节点列表
     * @param root 根节点
     * @return
     */
    public static <T extends TreeNode> List<T> bulid(List<T> treeNodes, Object root) {

        List<T> trees = new ArrayList<T>();

        for (T treeNode : treeNodes) {
            if (root.equals(treeNode.getParentId())) {	// 获取父节点下的第一层节点
                trees.add(treeNode);
            }

            for (T it : treeNodes) {	// 以当前值为父节点,查询子节点 (循环结构就形成了子节点->子节点->子节点)
                if (it.getParentId() == treeNode.getId()) {
                    if (treeNode.getChildren() == null) {
                        treeNode.setChildren(new ArrayList<TreeNode>());
                    }
                    treeNode.add(it);
                }
            }
        }
        return trees;
    }

    /**
     * 使用递归方法建树
     *
     * @param treeNodes
     * @param root 根节点
     * @return
     */
    public static <T extends TreeNode> List<T> buildByRecursive(List<T> treeNodes, Object root) {
        List<T> trees = new ArrayList<T>();
        for (T treeNode : treeNodes) {
            if (root.equals(treeNode.getParentId())) {
                trees.add(findChildren(treeNode, treeNodes));
            }
        }
        return trees;
    }

    /**
     * 递归查找子节点
     *
     * @param treeNodes
     * @return
     */
    public static <T extends TreeNode> T findChildren(T treeNode, List<T> treeNodes) {
        for (T it : treeNodes) {
            if (treeNode.getId() == it.getParentId()) {
                if (treeNode.getChildren() == null) {
                    treeNode.setChildren(new ArrayList<TreeNode>());
                }
                treeNode.add(findChildren(it, treeNodes));
            }
        }
        return treeNode;
    }

}
