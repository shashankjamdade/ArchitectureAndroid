package com.matrimony.demo.ui

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import androidx.annotation.Nullable
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.matrimony.demo.R
import com.matrimony.demo.listener.DatabaseListener
import com.matrimony.demo.listener.ItemClickListener
import com.matrimony.demo.model.UserListResponse
import com.matrimony.demo.repository.UserRepository
import com.matrimony.demo.util.CommonUtils
import com.matrimony.demo.viewmodel.UserListViewModel
import com.matrimony.demo.viewmodel.ViewModelProviderFactory
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.fragment_user_list.*
import javax.inject.Inject


class UserListActivity : DaggerAppCompatActivity(),
    ItemClickListener, DatabaseListener {

    private var userListView : View? = null
    lateinit var viewModel : UserListViewModel
    private var userListAdapter : UserListAdapter? = null
    private var clickedId : Int? = -1
    var mContainerId:Int = -1
//    var database: AppDatabase? = null

    @Inject
    lateinit var viewmodelProviderFactory: ViewModelProviderFactory

    @Inject
    lateinit var userRepository: UserRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_list)
        initViewModel()
        initAdapter()

//        if(CommonUtils.isOnline(this)){
            observeViewModel()
            viewModel.fetchUserListInfo(10)
//        }else{
//            DBOperations.getUserResponseFromDb(
//                database,
//                this,
//                this,
//                "userlist"
//            )
//        }
    }



    private fun initViewModel(){
        viewModel = ViewModelProviders.of(this, viewmodelProviderFactory).get(UserListViewModel::class.java)
    }

    private fun initAdapter(){
        userListAdapter = UserListAdapter(
            arrayListOf(),
            this@UserListActivity,
            this
        )
        userListRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = userListAdapter
        }
    }

    private fun observeViewModel(){

        val mObservableProduct: LiveData<UserListResponse>? =
            userRepository.getAllUsers();
        mObservableProduct?.observe(this, object : Observer<UserListResponse> {
            override fun onChanged(@Nullable itemlist: UserListResponse?) {
                userListAdapter?.refreshAdapter(itemlist?.results!!)
            }
        })
//        viewModel.fetchUsersLiveData().observe(this, Observer {
//            it?.let {
////                DBOperations.insertUsersInDb(
////                    it, database, this,"userlist"
////                )
//                val mObservableProduct: LiveData<UserListResponse>? =
//                    userRepository.getAllUsers();
//                mObservableProduct?.observe(this, object : Observer<UserListResponse> {
//                    override fun onChanged(@Nullable itemlist: UserListResponse?) {
//                       CommonUtils.printLog("DATARETR----> ","${Gson().toJson(itemlist)}")
//                        if(itemlist!=null){
//                            userListAdapter?.refreshAdapter(itemlist?.results!!)
//                        }
//                    }
//                })
////                userListAdapter?.refreshAdapter(it?.results!!)
//            }
//        })
//
//        viewModel.fetchLoadStatus().observe(this, Observer {
//            if(!it){
//                println(it)
//                loading_progress.visibility  = View.GONE
//            }
//        })
//
//        viewModel.fetchError().observe(this, Observer {
//            it?.let {
//                if(!TextUtils.isEmpty(it)){
//                    Toast.makeText(this,"$it", Toast.LENGTH_LONG).show()
//                }
//
//            }
//        })
    }


    override fun setClickedInfo(data: Any?) {
//        clickedId = data.id
//        launchDetailFragment()
    }

    override fun getUpdatedData(obj: Any?, apiName: String) {
        if(apiName.equals("userlist")){
            if(obj!=null && obj is UserListResponse){
                userListAdapter?.refreshAdapter(obj?.results!!)
            }
        }
    }

    override fun IsDataInserted(apiName: String) {
//        DBOperations.getUserResponseFromDb(
//            database,
//            this,
//            this,
//           "userlist"
//        )
    }

}