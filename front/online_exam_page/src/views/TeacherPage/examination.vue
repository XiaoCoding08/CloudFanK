<template>
  <el-button text @click="dialogVisible = true">
    创建考试  {{ a2.value }}
  </el-button>
  <!-- 弹框 -->
  <el-dialog
    v-model="dialogVisible"
    title="创建考试"
    width="50%"
  >

    <div class="block">
    <span class="demonstration">With shortcuts</span>
    <el-date-picker
      v-model="value2"
      type="datetimerange"
     
      :shortcuts="shortcuts"
      
      range-separator="To"
      start-placeholder="Start date"
      end-placeholder="End date"
    />
  </div>
    <template #footer>
      <span class="dialog-footer">
        <el-button @click="dialogVisible = false">取消</el-button>
        <el-button type="primary" @click="handlecreate">
          创建考试
        </el-button>
      </span>
    </template>
  </el-dialog>
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

import {useidStore,course_classinfoStore,classidStore,examidStore} from '@/stores/counter'
import httpParams  from '@/utils/httpparam'
const value1 = ref('')
const value2 = ref('')
const a1=course_classinfoStore()
const a2=ref(a1.id)
const classid=ref(classidStore().id)
const dialogVisible = ref(false)
const tableData=ref([])
const requestData2 = {
  classId: classid.value,

};
onMounted(() => { 
  httpParams.post('/teacher/queryClassExam', requestData2)
  .then(response => {
    console.log(response.data);
    // 注册成功，可以根据实际需求进行处理，比如跳转到登录页面
    //alert("创建成功");
    dialogVisible.value=false;
    
    tableData.value= response.data.data
    
  })
  .catch(error => {
    console.log(error);
    // 注册失败，可以根据实际需求进行处理，比如显示错误提示
    alert("创建失败，请重新创建");
  });
  console.log( '班级id'+classid.value) })

const form =ref 
({
   classname :'',
})
const handlecreate = () =>{

  const v1 = new Date(value2.value[0])
  const startDate = v1.getFullYear() + '-' + (v1.getMonth()+1).toString().padStart(2, '0') + '-' + v1.getDate().toString().padStart(2, '0') + ' ' + v1.getHours().toString().padStart(2, '0') + ':' + v1.getMinutes().toString().padStart(2, '0')

  const v2 = new Date(value2.value[1])
  const endDate = v2.getFullYear() + '-' + (v2.getMonth()+1).toString().padStart(2, '0') + '-' + v2.getDate().toString().padStart(2, '0') + ' ' + v2.getHours().toString().padStart(2, '0') + ':' + v2.getMinutes().toString().padStart(2, '0')
  //console.log("日期为"+ formattedDate),
// 发起注册请求，可以使用 axios 或者你定义的 httpInstance 来发送 POST 请求

const requestData = {

  endTime: endDate,
  classId:classid.value,
  startTime:startDate
};


  httpInstance.post('/teacher/addExam', requestData)
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
  id:0,
  startTime: '',
  endTime: '',
 
}

const handleEdit = (index: number, row: User) => {
  console.log(index, row)
  const classData = {
  id: row.id,
 
};

    const cr_cl=course_classinfoStore();
    cr_cl.setid(classData.id);
    const aa=examidStore();
    aa.setid(row.id);
    console.log('id = '+aa.id);
    
    window.location.href ='/teacher/expage';
   
  
}


const handleDelete = (index: number, row: User) => {
  console.log(index, row)
  const delectrequestData = {
  id: row.id,
 
};
httpInstance.post('/teacher/delExam',
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
const shortcuts = [
  {
    text: 'Last week',
    value: () => {
      const end = new Date()
      const start = new Date()
      start.setTime(start.getTime() - 3600 * 1000 * 24 * 7)
      return [start, end]
    },
  },
  {
    text: 'Last month',
    value: () => {
      const end = new Date()
      const start = new Date()
      start.setTime(start.getTime() - 3600 * 1000 * 24 * 30)
      return [start, end]
    },
  },
  {
    text: 'Last 3 months',
    value: () => {
      const end = new Date()
      const start = new Date()
      start.setTime(start.getTime() - 3600 * 1000 * 24 * 90)
      return [start, end]
    },
  },
]
</script>
<style lang="scss" scoped>
.app-container {
  
 
  position: fixed;

  
}
.demo-datetime-picker {
  display: flex;
  width: 100%;
  padding: 0;
  flex-wrap: wrap;
  justify-content: space-around;
  align-items: stretch;
}
.demo-datetime-picker .block {
  padding: 30px 0;
  text-align: center;
}
.line {
  width: 1px;
  background-color: var(--el-border-color);
}
</style>
