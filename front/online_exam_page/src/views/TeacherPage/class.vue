<template>
  <el-button text @click="dialogVisible = true">
    创建班级  {{ a2.value }}
  </el-button>
  <!-- 弹框 -->
  <el-dialog
    v-model="dialogVisible"
    title="创建班级"
    width="30%"
  >
  <!-- :model="joinform":rule="joinrule" -->
  <el-form :model="form" >
    <el-form-item>
      <el-input
            placeholder="输入班级名" v-model="form.classname"
          />
    </el-form-item>
    
    </el-form>  
    <template #footer>
      <span class="dialog-footer">
        <el-button @click="dialogVisible = false">取消</el-button>
        <el-button type="primary" @click="handlecreate">
          创建班级
        </el-button>
      </span>
    </template>
  </el-dialog>
  <!-- 数据列 -->
  <el-table :data="tableData" style="width: 200dvh; height: 80dvh;">
    <el-table-column label="班级号" width="250">
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
    <el-table-column label="班级名" width="250">
      <template #default="scope">
        <el-popover effect="light" trigger="hover" placement="top" width="auto">
          <template #default>
            <div>name: {{ scope.row.name }}</div>
          </template>
          <template #reference>
            <el-tag>{{ scope.row.name }}</el-tag>
          </template>
        </el-popover>
      </template>
    </el-table-column>
    
    <el-table-column label="Operations">
      <template #default="scope">
        <el-button size="small" @click="handleEdit(scope.$index, scope.row)"
          >进入</el-button
        >
        <el-button
          size="small"
          type="danger"
          @click="handleDelete(scope.$index, scope.row)"
          >删除</el-button
        >
      </template>
    </el-table-column>
  </el-table>
  <div>
    
  </div>
</template>

<script lang="ts" setup>

import { ref , onMounted} from 'vue'
import { ElMessageBox } from 'element-plus'
import httpInstance from '../../utils/http';
import {useidStore,course_classinfoStore,classidStore} from '@/stores/counter'
import httpParams  from '@/utils/httpparam'
const a1=course_classinfoStore()
const a2=ref(a1.id)
const dialogVisible = ref(false)
const tableData=ref([])
const requestData2 = {
  courseId: a2.value,
  page:0,
  size:100
};
onMounted(() => { 
  httpInstance.post('/teacher/queryBatchClass', requestData2)
  .then(response => {
    console.log(response.data);
    // 注册成功，可以根据实际需求进行处理，比如跳转到登录页面
   // alert("创建成功");
    dialogVisible.value=false;
    tableData.value= response.data.records
    
  })
  .catch(error => {
    console.log(error);
    // 注册失败，可以根据实际需求进行处理，比如显示错误提示
    alert("创建失败，请重新创建");
  });
  console.log(`the component is now mounted.`) })

const form =ref 
({
   classname :'',
})
const handlecreate = () =>{
// 首先，对表单进行验证，确保用户输入的数据符合要求
if (
  form.value.classname.trim() === '' 
  
) {
  // 如果有任何一个字段为空，可以给出提示或者阻止注册逻辑继续执行
  //console.log('请填写完整的注册信息');
  if( form.value.classname.trim() === '')
  {
    console.log('请填写classname的注册信息');
  }
  return;
}

// 发起注册请求，可以使用 axios 或者你定义的 httpInstance 来发送 POST 请求
const requestData = {
  courseId: a2.value,
  name: form.value.classname
};


  httpInstance.post('/teacher/addClass', requestData)
  .then(response => {
    console.log(response.data);
    // 注册成功，可以根据实际需求进行处理，比如跳转到登录页面
    alert("创建成功");
    dialogVisible.value=false;
   
  })
  .catch(error => {
    console.log(error);
    // 注册失败，可以根据实际需求进行处理，比如显示错误提示
    alert("创建失败，请重新创建");
  });


};
const input=ref()
interface User {
  id:0
  name: string
  teacher: string
 
}

const handleEdit = (index: number, row: User) => {
  console.log(index, row)
  const classid = row.id ;

    const cr_cl=classidStore();
    cr_cl.setid(classid);
    console.log(classid)
    window.location.href ='/teacher/exam';
   
  
}


const handleDelete = (index: number, row: User) => {
  console.log(index, row)
  const delectrequestData = {
  id: row.id,
 
};
httpParams.post('/teacher/delOneClass',
{
  id:delectrequestData.id
})
  .then(response => {
    console.log(response.data);
    // 注册成功，可以根据实际需求进行处理，比如跳转到登录页面
    alert("删除成功");
   
   
  })
  .catch(error => {
    console.log(error);
    // 注册失败，可以根据实际需求进行处理，比如显示错误提示
    alert("删除失败，请重试");
  });

}


</script>
<style lang="scss" scoped>
.app-container {
  
 
  position: fixed;

  
}
</style>