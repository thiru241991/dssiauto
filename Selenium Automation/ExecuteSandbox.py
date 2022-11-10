from HtmlTestRunner.runner import HTMLTestRunner
import unittest
import SandboxEdgeunittestEX


if __name__ == '__main__':
    #-->Method Execution
    suite = unittest.TestSuite()
    suite.addTest(SandboxEdgeunittestEX.Automation('test_001_login'))
    suite.addTest(SandboxEdgeunittestEX.Automation('test_002_AddProduct'))
    suite.addTest(SandboxEdgeunittestEX.Automation('test_003_AddingSimpleproduct'))
    suite.addTest(SandboxEdgeunittestEX.Automation('test_004_ConfigurePrdSave'))
    suite.addTest(SandboxEdgeunittestEX.Automation('test_005_BulkAddPrd'))
    suite.addTest(SandboxEdgeunittestEX.Automation('test_006_ApplyingBulkDiscount'))
    suite.addTest(SandboxEdgeunittestEX.Automation('test_007_SelfApprovingQuote'))
    suite.addTest(SandboxEdgeunittestEX.Automation('test_008_CreatingRFO'))
    suite.addTest(SandboxEdgeunittestEX.Automation('test_009_CreatingNewRevision'))
    suite.addTest(SandboxEdgeunittestEX.Automation('test_010_BulkDeletingProducts'))
    suite.addTest(SandboxEdgeunittestEX.Automation('test_011_UpdatingExcel'))

    #-->Test Runner Execution
    runner = HTMLTestRunner(output='Test Reports',report_title = 'Automation Test Results',report_name = 'Test Report',open_in_browser=True)
    runner.run(suite)