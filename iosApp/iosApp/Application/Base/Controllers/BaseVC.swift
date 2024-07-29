//
//  BaseVC.swift
//  Presentation
//
//  Created by thanos kottaridis on 29/1/23.
//

import UIKit

open class BaseVC: UIViewController {

    // MARK: - VARS
    /// this helper var indicates if viewController is visible (top on the stack)
    var isVisible: Bool = false
    /// this var is used to set up swipe back gesture
    private var isSwipeBackEnable: Bool
    /// this helper var is used to hide nav bar when push controller
    private var hideNavigationBar: Bool
    
    // MARK: - DEFAULT INIT
    /**
     This constructor is the default contractor of BaseVC instance.
     `A Default BaseVC has `
     - enable swipe back gesture recogniser
     - disable/hidden tab bar
     - disable/hidden top navigation bar
     */
    override public init(nibName nibNameOrNil: String?, bundle nibBundleOrNil: Bundle?) {
        self.isSwipeBackEnable = true
        self.hideNavigationBar = true
        super.init(nibName: nibNameOrNil, bundle: nibBundleOrNil)
        hidesBottomBarWhenPushed = true
    }
    
    // MARK: - BASE VC CUSTOM INIT
    /**
     This constructor is used in order to specify tab bar, swipe back and top navigation bar behaviour for this VC
     
     - Parameter hideNavigationBar Determines if navigation bar is visible for this VC
     - Parameter hideTabBar: Determines if tab bar is visible for this VC
     - Parameter isSwipeBackEnable: Determines if swipe back is enable for this VC
     */
    public init(
        nibName nibNameOrNil: String?,
        bundle nibBundleOrNil: Bundle?,
        hideNavigationBar: Bool = true,
        hideTabBar: Bool = true,
        isSwipeBackEnable: Bool = true
    ) {
        self.isSwipeBackEnable = isSwipeBackEnable
        self.hideNavigationBar = hideNavigationBar
        super.init(nibName: nibNameOrNil, bundle: nibBundleOrNil)
        hidesBottomBarWhenPushed = hideTabBar
    }
    
    required public init?(coder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
    
    
    open override func viewDidLoad() {
        super.viewDidLoad()
        
        // set up background color
        // TODO: - Use Color Pallet
        view.backgroundColor = .white //ColorPalette.BackgroundDefaultPrimary.value

        // call template functions in proper order
        setupView()
        setUpObservers()
        populateData()
    }
    
    open override func viewDidAppear(_ animated: Bool) {
        super.viewDidAppear(animated)
        isVisible = true
        
        /// sets up if swipe back gesture is enable and if navigation bar is visible for this VC
        navigationController?.interactivePopGestureRecognizer?.isEnabled = isSwipeBackEnable
        navigationController?.navigationBar.isHidden = hideNavigationBar
    }
    
    open override func viewWillDisappear(_ animated: Bool) {
        super.viewWillDisappear(animated)

        isVisible = false
    }
    
    //MARK: - OPEN FUNCS FOR CHILD VC
    open func setupView() {}
    open func setUpObservers() {}
    open func populateData() {}
}
