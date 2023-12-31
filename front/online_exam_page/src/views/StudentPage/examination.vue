
<template>
 
  <!-- 数据列 -->
  <el-table :data="tableData" style="width: 200dvh; height: 80dvh;">
    <el-table-column label="考试号" width="250">
      <template #default="scope">
        <el-popover effect="light" trigger="hover" placement="top" width="auto">
          <template #default>
            <div>id: {{ scope.row.id }}</div>
           
          </template>
          <template #reference>
            <el-tag>{{ scope.row.id }}</el-tag>
          </template>
        </el-popover>
      </template>
    </el-table-column>
    <el-table-column label="考试开始时间" width="250">
      <template #default="scope">
        <el-popover effect="light" trigger="hover" placement="top" width="auto">
          <template #default>
            <div>startTime: {{ scope.row.startTime }}</div>
           
          </template>
          <template #reference>
            <el-tag>{{ scope.row.startTime }}</el-tag>
          </template>
        </el-popover>
      </template>
    </el-table-column>
    <el-table-column label="考试结束时间" width="250">
      <template #default="scope">
        <el-popover effect="light" trigger="hover" placement="top" width="auto">
          <template #default>
            <div>endTime: {{ scope.row.endTime }}</div>
          
          </template>
          <template #reference>
            <el-tag>{{ scope.row.endTime }}</el-tag>
          </template>
        </el-popover>
      </template>
    </el-table-column>
   
    <el-table-column label="Operations">
      <template #default="scope">
        <el-button size="small" @click="handleEdit(scope.$index, scope.row)"
          >进入</el-button
        >
    
      </template>
    </el-table-column>
  </el-table>
  <div>
    
  </div>
</template>

<script lang="ts" setup>

import { ref,onMounted } from 'vue'
import { ElMessageBox } from 'element-plus'
import axios from 'axios'
import {useidStore,course_classinfoStore,classidStore,examidStore} from '@/stores/counter'
import httpInstance from '../../utils/http';
import httpParams from '@/utils/httpparam';
const dialogVisible = ref(false)
const input=ref()
const classid=ref(classidStore().id)
interface User {
  id:null,
  startTime:'',
  endTime:''
}
const requestData2 = {
  classId:classid.value,
}
const tableData=ref([])
onMounted(() => { 
  httpParams.post('/student/queryClassExam', requestData2)
  .then(response => {
    console.log(response.data);
    // 注册成功，可以根据实际需求进行处理，比如跳转到登录页面
    //alert("创建成功");
  
    tableData.value= response.data.data

  })
  .catch(error => {
    console.log(error);
    // 注册失败，可以根据实际需求进行处理，比如显示错误提示
    alert(classid.value);
  });
  console.log(`the component is now mounted.`) })

const handleEdit = (index: number, row: User) => {
  console.log(index, row)
  const classData = {
  id: row.id,
 
};

    const exid=examidStore();
    exid.setid(classData.id);
    //alert(row.id);
    window.location.href ='/student/exampage';
    
}




</script>
<style lang="scss" scoped>
.app-container {
  
 
  position: fixed;

  
}
</style>