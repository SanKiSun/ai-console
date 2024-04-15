import request from '@/utils/request'

// 查询FAQ管理列表
export function listFaq(query) {
  return request({
    url: '/ai/faq/list',
    method: 'get',
    params: query
  })
}

// 查询FAQ管理详细
export function getFaq(id) {
  return request({
    url: '/ai/faq/' + id,
    method: 'get'
  })
}

// 新增FAQ管理
export function addFaq(data) {
  return request({
    url: '/ai/faq',
    method: 'post',
    data: data
  })
}

// 修改FAQ管理
export function updateFaq(data) {
  return request({
    url: '/ai/faq',
    method: 'put',
    data: data
  })
}

// 删除FAQ管理
export function delFaq(id) {
  return request({
    url: '/ai/faq/' + id,
    method: 'delete'
  })
}
