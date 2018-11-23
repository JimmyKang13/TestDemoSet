package org.pap.policySearcher;


import java.util.HashSet;
import java.util.List;

@SuppressWarnings({"unchecked","rawtypes"})
public class ListRemoveDuplicate 
{
	//列表中数据的去重
	static List removeDuplicate(List list)
	{
		HashSet set = new HashSet(list);
		list.clear();
		list.addAll(set);
		return list;
	}
}
