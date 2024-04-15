import request from '@/utils/request'

// 查询file列表
export function listFile(query) {
  return request({
    url: '/ai/file/list',
    method: 'get',
    params: query
  })
}

// 查询file详细
export function getFile(id) {
  return request({
    url: '/ai/file/' + id,
    method: 'get'
  })
}

// 新增file
export function addFile(data) {
  return request({
    url: '/ai/file',
    method: 'post',
    data: data
  })
}

// 修改file
export function updateFile(data) {
  return request({
    url: '/ai/file',
    method: 'put',
    data: data
  })
}

// 删除file
export function delFile(id) {
  return request({
    url: '/ai/file/' + id,
    method: 'delete'
  })
}
